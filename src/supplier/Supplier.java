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

    // LEER CINE

    public Cine[] readCine(String where) {

        if (where != null) {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "cines" }, where);

            Cine[] cines = new Cine[lectura.length];

            for (int i = 0; i < cines.length; i++) {
                cines[i] = new Cine();
                transformaCine(lectura[i], cines[i]);
            }

            return cines;

        } else {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "cines" }, null);

            Cine[] cines = new Cine[lectura.length];

            for (int i = 0; i < cines.length; i++) {
                cines[i] = new Cine();
                transformaCine(lectura[i], cines[i]);
            }

            return cines;

        }

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

    // LEER SALA

    public Sala[] readSala(String where) {

        if (where != null) {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "salas" }, where);
           
            Sala[] salas = new Sala[lectura.length];

            for (int i = 0; i < salas.length; i++) {
                salas[i] = new Sala();
                transformaSala(lectura[i], salas[i]);
            }

            return salas;
        } else {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "salas" }, null);
          
            Sala[] salas = new Sala[lectura.length];

            for (int i = 0; i < salas.length; i++) {
                salas[i] = new Sala();
                transformaSala(lectura[i], salas[i]);
            }

            return salas;

        }

    }

    public void transformaSala(String cadena, Sala sala) {

        int primerSeparador = cadena.indexOf(MiCrud.SEPARADOR);
       
        int segundoSeparador = primerSeparador + MiCrud.SEPARADOR.length();
        

        int id = Integer.parseInt(cadena.substring(0, cadena.indexOf(MiCrud.SEPARADOR)));
        int capacidad = Integer.parseInt(cadena.substring(primerSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador)));
        double metros = Double.parseDouble(
                cadena.substring(cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador) + MiCrud.SEPARADOR.length()));

        sala.setIdentificadorSala(id);
        sala.setCapacidad(capacidad);
        sala.setMetrosCuadrados(metros);
    }

    // LEER PELICULA

    public Pelicula[] readPelicula(String where) {

        if (where != null) {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "peliculas" }, where);

            for (int i = 0; i < lectura.length; i++) {
                System.out.println(lectura[i]);
            }
            Pelicula[] peli = new Pelicula[lectura.length];

            for (int i = 0; i < peli.length; i++) {
                peli[i] = new Pelicula();
                transformaPelicula(lectura[i], peli[i]);
            }

            return peli;
        } else {
            String[] lectura = miCrud.readBD(new String[] { "*" },
                    new String[] { "peliculas" }, null);

            for (int i = 0; i < lectura.length; i++) {
                System.out.println(lectura[i]);
            }
            Pelicula[] peli = new Pelicula[lectura.length];

            for (int i = 0; i < peli.length; i++) {
                peli[i] = new Pelicula();
                transformaPelicula(lectura[i], peli[i]);
            }

            return peli;
        }

    }

    public void transformaPelicula(String cadena, Pelicula pelicula) {

        int primerSeparador = cadena.indexOf(MiCrud.SEPARADOR);
        System.out.println(primerSeparador);
        int segundoSeparador = cadena.indexOf(MiCrud.SEPARADOR, primerSeparador + 2);
        System.out.println(segundoSeparador);
        int tercerSeparador = cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador + 2);
        System.out.println(tercerSeparador);
        int cuartoSeparador = cadena.indexOf(MiCrud.SEPARADOR, tercerSeparador + 2);
        System.out.println(cuartoSeparador);
        int quintoSeparador = cadena.indexOf(MiCrud.SEPARADOR, cuartoSeparador + 2);
        System.out.println(quintoSeparador);
        int sextoSeparador = cadena.indexOf(MiCrud.SEPARADOR, quintoSeparador + 2);
        System.out.println(sextoSeparador);

        int id = Integer.parseInt(cadena.substring(0, cadena.indexOf(MiCrud.SEPARADOR)));

        String titulo = cadena.substring(primerSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, segundoSeparador));
        int duracion = Integer.parseInt(cadena.substring(segundoSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, tercerSeparador)));
        String genero = cadena.substring(tercerSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, cuartoSeparador));
        String director = cadena.substring(cuartoSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, quintoSeparador));
        String clasEdad = cadena.substring(quintoSeparador + MiCrud.SEPARADOR.length(),
                cadena.indexOf(MiCrud.SEPARADOR, sextoSeparador));

        double precio = Double.parseDouble(
                cadena.substring(cadena.indexOf(MiCrud.SEPARADOR, sextoSeparador) + MiCrud.SEPARADOR.length()));

        pelicula.setIdentificadorPelicula(id);
        pelicula.setTitulo(titulo);
        pelicula.setDuracionMinutos(duracion);
        pelicula.setGenero(genero);
        pelicula.setDirector(director);
        pelicula.setClasificacionPorEdad(clasEdad);
        pelicula.setPrecio(precio);
    }

    // BORRAR FILAS

    public int deleteCine(String columna, String valor) {

        return miCrud.deleteRows("cines", (columna + " = " + valor));

    }

    public int deleteSala(String columna, String valor) {

        return miCrud.deleteRows("sala", (columna + " = " + valor));

    }

    public int deletePelicula(String columna, String valor) {

        return miCrud.deleteRows("peliculas", (columna + " = " + valor));

    }

    // MODIFICAR

    public int modificaCine(String[][] nuevosValores, String columna, String valor) {

        return miCrud.updateTable("cines", nuevosValores, columna + " = " + valor);

    }

    public int modificaSala(String[][] nuevosValores, String columna, String valor) {

        return miCrud.updateTable("salas", nuevosValores, columna + " = " + valor);

    }

    public int modificaPelicula(String[][] nuevosValores, String columna, String valor) {

        return miCrud.updateTable("peliculas", nuevosValores, columna + " = " + valor);

    }

}
