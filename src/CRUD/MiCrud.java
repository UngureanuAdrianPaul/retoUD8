
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MiCrud {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";

    private Connection connection;
    private Statement statement;
    public static final String SEPARADOR = " / ";

    // constructor

    public MiCrud(String basedeDatos) {

        this.url = this.url.concat(basedeDatos);

    }

    // iniciar conexion
    private boolean initConnection() {
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // cerrar conexion
    private boolean closeConnection() {
        try {
            this.connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

    }

    // crear Statement
    private boolean createStatement() {

        try {
            this.statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // INSERTAR FILAS
    public boolean insertRow(String table, String[] nomCol, Object[] values) {
        initConnection();
        createStatement();
        String query = "INSERT INTO " + table + " (";
        for (int i = 0; i < nomCol.length - 1; i++) {
            query = query + nomCol[i] + ", ";

        }
        query = query + nomCol[nomCol.length - 1] + ") VALUES (";

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i].getClass() == Integer.class) {
                query = query + values[i] + ", ";
            } else {
                query = query + "'" + values[i] + "'" + ", ";
            }

        }
        if (values[values.length - 1].getClass() == Integer.class) {
            query = query + values[values.length - 1] + ");";
        } else {
            query = query + "'" + values[values.length - 1] + "'" + ");";
        }

        System.out.println(query);

        try {

            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }
    }

    // LEER DE LA BASE DE DATOS
    public String[] readBD(String[] select, String[] from, String where) {

        initConnection();
        createStatement();
        if (select == null || from == null) {
            return null;
        } else {
            for (String string : select) {
                if (string == null) {
                    return null;
                }
            }
            for (String string : from) {
                if (string == null) {
                    return null;
                }
            }
        }

        String myQuery = "SELECT ";

        for (int i = 0; i < select.length - 1; i++) {
            myQuery = myQuery + select[i] + ", ";
        }
        myQuery = myQuery + select[select.length - 1] + " ";

        myQuery = myQuery + "FROM ";
        for (int i = 0; i < from.length - 1; i++) {
            myQuery = myQuery + from[i] + ", ";
        }

        myQuery = myQuery + from[from.length - 1];

        if (where != null) {
            myQuery = myQuery + " WHERE " + where + " ;";
        } else {
            myQuery = myQuery + ";";
        }

        try {
            ResultSet resultSet = this.statement.executeQuery(myQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numRows = 0;
            int numCol = metaData.getColumnCount();
            while (resultSet.next()) {
                numRows = resultSet.getRow();
            }
            String[] vista = new String[numRows];
            resultSet.beforeFirst();
            for (int i = 0; i < vista.length; i++) {
                resultSet.next();
                vista[i] = "";
                for (int j = 1; j < numCol; j++) {
                    vista[i] = vista[i] + resultSet.getString(j) + SEPARADOR;
                }
                vista[i] = vista[i] + resultSet.getString(numCol);

            }
            return vista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }

    }

    // DROP Y DELETE

    public int deleteRows(String table, String condition) {
        initConnection();
        createStatement();
        String query = "DELETE FROM " + table;

        if (condition != null) {
            query = query + " WHERE " + condition + " ;";
        } else {
            query = query + ";";
        }

        try {
            return (this.statement.executeUpdate(query));
        } catch (SQLException e) {
            return -1;
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }
    }

    public boolean dropTable(String table) {
        initConnection();
        createStatement();

        try {
            this.statement.executeUpdate("DROP TABLE " + table + ";");
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }

    }

    public int updateTable(String tabla, String[][] colValor, String condicion) {

        if (tabla == null || colValor == null) {
            return -1;
        } else {
            for (String[] string : colValor) {
                if (string[0] == null || string[1] == null) {
                    return -1;
                }
            }
        }

        initConnection();
        createStatement();

        String myQuery = "UPDATE " + tabla + " SET ";

        for (int i = 0; i < colValor.length - 1; i++) {

            myQuery = myQuery + colValor[i][0] + " = " + colValor[i][1] + " , ";
        }

        myQuery = myQuery + colValor[colValor.length - 1][0] + " = " + colValor[colValor.length - 1][1];

        if (condicion != null) {
            myQuery = myQuery + " WHERE " + condicion;

        }
        myQuery = myQuery + ";";

        System.out.println(myQuery);

        try {
            return (this.statement.executeUpdate(myQuery));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }

    }

}