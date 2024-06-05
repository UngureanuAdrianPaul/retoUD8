package supplier;

import java.sql.SQLException;
import java.util.Scanner;

import CRUD.MiCrud;
import tablas.Cine;
import tablas.Sala;
import tablas.Pelicula;

public class Supplier {

    private MiCrud miCrud;

    public Supplier(String baseDatos) {

        miCrud = new MiCrud(baseDatos);

    }

    // INSERTAR ELEMENTOS

    public boolean insert(Cine cine) {

        return miCrud.insertRow("cines", new String[] { "direccion", "identificador", "nombre_del_cine" },
                new Object[] { cine.getDireccion(), cine.getIdentificadorCine(), cine.getNombreCine() });
    }

    public boolean insert(Sala sala) {

        return miCrud.insertRow("salas", new String[] { "identificador", "capacidad", "metros_cuadrados" },
                new Object[] { sala.getIdentificadorSala(), sala.getCapacidad(), sala.getMetrosCuadrados() });

    }

    public boolean insert(Pelicula peli) {

        return miCrud.insertRow("peliculas",
                new String[] { "identificador", "titulo", "duracionMinutos", "genero", "director",
                        "clasificacion_por_edad", "precio" },
                new Object[] { peli.getIdentificadorPelicula(), peli.getTitulo(), peli.getDuracionMinutos(),
                        peli.getGenero(), peli.getDirector(), peli.getClasificacionPorEdad(), peli.getPrecio() });

    }

    // LEER

    public Cine[] readCine() {

        String[] lectura = miCrud.readBD(new String[] { "*" },
                new String[] { "cines" }, null);

        Cine[] cines = new Cine[lectura.length];

        for (int i = 0; i < cines.length; i++) {
            cines[i] = new Cine();
            transformaCine(lectura[i], cines[i]);

        }

        return cines;
    }

    public void transformaCine(String cadena, Cine cine) {

        int primerSeparador = cadena.indexOf(MiCrud.SEPARADOR);
        int segundoSeparador = primerSeparador + MiCrud.SEPARADOR.length();

        int id = Integer.parseInt(cadena.substring(0, cadena.indexOf(MiCrud.SEPARADOR)));
        String nombre = cadena.substring(primerSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador));
        String dir = cadena.substring(cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador) + MiCrud.SEPARADOR.length());

        cine.setDireccion(dir);
        cine.setIdentificadorCine(id);
        cine.setNombreCine(nombre);

        
    }

    public String[] read(Sala sala) {

        return miCrud.readBD(new String[] { "*" },
                new String[] { "salas" }, null);
    }

    public String[] read(Pelicula peli) {

        return miCrud.readBD(new String[] { "*" },
                new String[] { "peliculas" }, null);
    }

    // BORRAR FILA
    public int delete(Cine cine) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Inserta la condición de borrado de filas: ");
        String condicion = teclado.nextLine();
        teclado.close();

        return miCrud.deleteRows("cines", condicion);

    }

    public int delete(Sala sala) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Inserta la condición de borrado de filas: ");
        String condicion = teclado.nextLine();
        teclado.close();

        return miCrud.deleteRows("salas", condicion);

    }

    public int delete(Pelicula peli) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Inserta la condición de borrado de filas: ");
        String condicion = teclado.nextLine();
        teclado.close();

        return miCrud.deleteRows("peliculas", condicion);
    }

    // ELIMINAR TABLA

    public boolean drop(Cine cine) {

        return miCrud.dropTable("cines");
    }

    public boolean drop(Sala sala) {

        return miCrud.dropTable("salas");
    }

    public boolean drop(Pelicula peli) {

        return miCrud.dropTable("peliculas");
    }

}
