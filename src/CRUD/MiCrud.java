
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiCrud {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";

    private Connection connection;
    private Statement statement;

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
            if(connection != null) {
                closeConnection();
            }
        }

    }

}