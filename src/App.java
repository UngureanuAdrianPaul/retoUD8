
import java.util.Scanner;

import supplier.Supplier;
import tablas.Cine;
import tablas.Pelicula;
import tablas.Sala;

public class App {
    public static void main(String[] args) {

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        int numTabla;
        int numOperacion;
        Supplier suministrador = new Supplier("cinema");

        // START

        presentacion();

        do {
            numOperacion = teclado.nextInt();
            teclado.nextLine();
            System.out.println();

            switch (numOperacion) {
                case 1:

                    // INSERTAR

                    System.out.println("Inserte la tabla a la que quiere aplicar la inserción:");
                    System.out.println();
                    System.out.println("1.Cines       2.Salas       3.Películas ");

                    do {
                        numTabla = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println();

                        switch (numTabla) {

                            case 1:
                                // inserto cine
                                Cine cine = new Cine();
                                System.out.println();
                                System.out.println("Inserte los valores correspondientes. ");
                                System.out.println();
                                System.out.println("Nombre del Cine: ");
                                cine.setNombreCine(teclado.nextLine());
                                System.out.println("Dirección: ");
                                cine.setDireccion(teclado.nextLine());
                                System.out.println("Identificador: ");
                                cine.setIdentificadorCine(teclado.nextInt());
                                teclado.nextLine();

                                System.out.println(
                                        "¿La inserción se ha ejecutado correctamente?: " + suministrador.insert(cine));

                                break;
                            case 2:
                                // inserto sala
                                Sala sala = new Sala();
                                System.out.println();
                                System.out.println("Inserte los valores correspondientes. ");
                                System.out.println();
                                System.out.println("Capacidad: ");
                                sala.setCapacidad(teclado.nextInt());
                                teclado.nextLine();
                                System.out.println("Metros cuadrados: ");
                                sala.setMetrosCuadrados(teclado.nextDouble());
                                teclado.nextLine();
                                System.out.println("Identificador: ");
                                sala.setIdentificadorSala(teclado.nextInt());
                                teclado.nextLine();

                                System.out.println(
                                        "¿La inserción se ha ejecutado correctamente?: " + suministrador.insert(sala));

                                break;
                            case 3:
                                // inserto peli
                                Pelicula peli = new Pelicula();
                                System.out.println();
                                System.out.println("Inserte los valores correspondientes. ");
                                System.out.println();
                                System.out.println("Título:");
                                peli.setTitulo(teclado.nextLine());
                                System.out.println("Duración");
                                peli.setDuracionMinutos(teclado.nextInt());
                                teclado.nextLine();
                                System.out.println("Género:");
                                peli.setGenero(teclado.nextLine());
                                System.out.println("Director:");
                                peli.setDirector(teclado.nextLine());
                                System.out.println("Clasificación edad:");
                                peli.setClasificacionPorEdad(teclado.nextLine());
                                teclado.nextLine();
                                System.out.println("Precio:");
                                peli.setPrecio(teclado.nextDouble());
                                teclado.nextLine();

                                System.out.println(
                                        "¿La inserción se ha ejecutado correctamente?: " + suministrador.insert(peli));

                                break;

                            default:
                                System.out
                                        .println("Número incorrecto, introduzca de nuevo el número de tabla adecuado.");
                                break;
                        }
                    } while (numTabla < 1 || numTabla > 3);

                    break;

                case 2:

                    // LEER

                    System.out.println("Inserte la tabla a la que quiere aplicar la lectura:");
                    System.out.println();
                    System.out.println("1.Cines       2.Salas       3.Películas ");

                    do {
                        numTabla = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println();
                        switch (numTabla) {

                            case 1:
                                // leo cine

                                System.out.println("¿Desea insertar una condición de filtrado de filas?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaCine = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();
                                do {

                                    if (entradaCine == 'S') {
                                        System.out.println("Introduzca dicha condición: ");
                                        String condicion = teclado.nextLine();
                                        Cine[] cine = suministrador.readCine(condicion);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Cine cines : cine) {
                                            System.out.println(cines);
                                        }

                                    } else if (entradaCine == 'N') {
                                        Cine[] cine = suministrador.readCine(null);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Cine cines : cine) {
                                            System.out.println(cines);
                                        }

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaCine = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaCine == 'S') {
                                            System.out.println("Introduzca dicha condición: ");
                                            String condicion = teclado.nextLine();
                                            Cine[] cine = suministrador.readCine(condicion);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Cine cines : cine) {
                                                System.out.println(cines);
                                            }

                                        } else if (entradaCine == 'N') {
                                            Cine[] cine = suministrador.readCine(null);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Cine cines : cine) {
                                                System.out.println(cines);
                                            }

                                        }

                                    }
                                } while (entradaCine != 'S' && entradaCine != 'N');

                                break;
                            case 2:
                                // leo sala
                                System.out.println("¿Desea insertar una condición de filtrado de filas?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaSala = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();
                                do {

                                    if (entradaSala == 'S') {
                                        System.out.println("Introduzca dicha condición: ");
                                        String condicion = teclado.nextLine();
                                        Sala[] sala = suministrador.readSala(condicion);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Sala salas : sala) {
                                            System.out.println(salas);
                                        }

                                    } else if (entradaSala == 'N') {
                                        Sala[] sala = suministrador.readSala(null);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Sala salas : sala) {
                                            System.out.println(salas);
                                        }

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaSala = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaSala == 'S') {
                                            System.out.println("Introduzca dicha condición: ");
                                            String condicion = teclado.nextLine();
                                            Sala[] sala = suministrador.readSala(condicion);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Sala salas : sala) {
                                                System.out.println(salas);
                                            }

                                        } else if (entradaSala == 'N') {
                                            Sala[] sala = suministrador.readSala(null);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Sala salas : sala) {
                                                System.out.println(salas);
                                            }

                                        }
                                        // ERROR AQUI, NO SE COMO SE SALE DEL BUCLE INFINITO

                                    }
                                } while (entradaSala != 'S' && entradaSala != 'N');
                                break;
                            case 3:
                                // leo peli

                                System.out.println("¿Desea insertar una condición de filtrado de filas?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaPeli = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();
                                do {

                                    if (entradaPeli == 'S') {
                                        System.out.println("Introduzca dicha condición: ");
                                        String condicion = teclado.nextLine();
                                        Pelicula[] peli = suministrador.readPelicula(condicion);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Pelicula pelis : peli) {
                                            System.out.println(pelis);
                                        }

                                    } else if (entradaPeli == 'N') {
                                        Pelicula[] peli = suministrador.readPelicula(null);

                                        System.out.println();
                                        System.out.println("El resultado de su consulta es:");
                                        System.out.println();

                                        for (Pelicula pelis : peli) {
                                            System.out.println(pelis);
                                        }

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaPeli = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaPeli == 'S') {
                                            System.out.println("Introduzca dicha condición: ");
                                            String condicion = teclado.nextLine();
                                            Pelicula[] peli = suministrador.readPelicula(condicion);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Pelicula pelis : peli) {
                                                System.out.println(pelis);
                                            }

                                        } else if (entradaPeli == 'N') {
                                            Pelicula[] peli = suministrador.readPelicula(null);

                                            System.out.println();
                                            System.out.println("El resultado de su consulta es:");
                                            System.out.println();

                                            for (Pelicula pelis : peli) {
                                                System.out.println(pelis);
                                            }

                                        }
                                        // ERROR AQUI, NO SE COMO SE SALE DEL BUCLE INFINITO
                                    }
                                } while (entradaPeli != 'S' && entradaPeli != 'N');

                                break;

                            default:
                                System.out.println("Inserte un número de tabla correcto");
                                break;
                        }

                    } while (numTabla < 1 || numTabla > 3);

                    break;

                case 3:
                    // BORRAR

                    System.out.println("Inserte la tabla a la que quiere aplicar el borrado:");
                    System.out.println();
                    System.out.println("1.Cines       2.Salas       3.Películas ");

                    do {
                        numTabla = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println();

                        switch (numTabla) {
                            case 1: // borro de cine
                                System.out.println("¿Desde borrar todas la filas de la tabla Cine?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaCine = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();

                                do {
                                    if (entradaCine == 'S') {
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deleteCine(null, null, null) + " filas");

                                    } else if (entradaCine == 'N') {

                                        System.out.println("Introduzca dicha condición: ");
                                        System.out.println("Columna: ");
                                        String columna = teclado.nextLine();
                                        System.out.println("Valor: ");
                                        String valor = teclado.nextLine();
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deleteCine(columna, valor, "1") + " fila");

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaCine = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaCine == 'S') {

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deleteCine(null, null, null) + " filas");

                                        } else if (entradaCine == 'N') {

                                            System.out.println("Introduzca dicha condición: ");
                                            System.out.println("Columna");
                                            String columna = teclado.nextLine();
                                            System.out.println("Valor");
                                            String valor = teclado.nextLine();

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deleteCine(columna, valor, "1") + " fila");
                                        }

                                    }
                                } while (entradaCine != 'S' && entradaCine != 'N');

                                break;
                            case 2: // borro de sala
                                System.out.println("¿Desde borrar todas la filas de la tabla Sala?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaSala = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();

                                do {
                                    if (entradaSala == 'S') {
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deleteSala(null, null, null) + " filas");

                                    } else if (entradaSala == 'N') {

                                        System.out.println("Introduzca dicha condición: ");
                                        System.out.println("Columna: ");
                                        String columna = teclado.nextLine();
                                        System.out.println("Valor: ");
                                        String valor = teclado.nextLine();
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deleteSala(columna, valor, "1") + " fila");

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaSala = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaSala == 'S') {

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deleteSala(null, null, null) + " filas");

                                        } else if (entradaSala == 'N') {

                                            System.out.println("Introduzca dicha condición: ");
                                            System.out.println("Columna");
                                            String columna = teclado.nextLine();
                                            System.out.println("Valor");
                                            String valor = teclado.nextLine();

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deleteSala(columna, valor, "1") + " fila");
                                        }

                                    }
                                } while (entradaSala != 'S' && entradaSala != 'N');
                                break;

                            case 3: // borro de pelicula

                                System.out.println("¿Desde borrar todas la filas de la tabla Pelicula?");
                                System.out.println("Pulse S para 'Sí' o N para 'No'");
                                char entradaPelicula = teclado.next().toUpperCase().charAt(0);
                                teclado.nextLine();

                                do {
                                    if (entradaPelicula == 'S') {
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deletePelicula(null, null, null) + " filas");

                                    } else if (entradaPelicula == 'N') {

                                        System.out.println("Introduzca dicha condición: ");
                                        System.out.println("Columna: ");
                                        String columna = teclado.nextLine();
                                        System.out.println("Valor: ");
                                        String valor = teclado.nextLine();
                                        System.out.println("Se han borrado un total de "
                                                + suministrador.deletePelicula(columna, valor, "1") + " fila");

                                    } else {
                                        System.out.println("Introduzca correctamente la letra.");
                                        entradaPelicula = teclado.next().toUpperCase().charAt(0);
                                        teclado.nextLine();

                                        if (entradaPelicula == 'S') {

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deletePelicula(null, null, null) + " filas");

                                        } else if (entradaPelicula == 'N') {

                                            System.out.println("Introduzca dicha condición: ");
                                            System.out.println("Columna");
                                            String columna = teclado.nextLine();
                                            System.out.println("Valor");
                                            String valor = teclado.nextLine();

                                            System.out.println("Se han borrado un total de "
                                                    + suministrador.deletePelicula(columna, valor, "1") + " fila");
                                        }

                                    }
                                } while (entradaPelicula != 'S' && entradaPelicula != 'N');
                                break;

                            default:
                                System.out.println("Inserte un número de tabla correcto");
                                break;
                        }

                    } while (numTabla < 1 || numTabla > 3);

                    break;

                case 4:

                    // MODIFICAR

                    System.out.println("Inserte la tabla a la que quiere aplicar la modificacion:");
                    System.out.println();
                    System.out.println("1.Cines       2.Salas       3.Películas ");

                    do {
                        numTabla = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println();

                        switch (numTabla) {
                            case 1: // modifico cine

                                break;
                            case 2: // modifico sala

                                break;

                            case 3: // modifico pelicula

                                break;

                            default:
                                System.out.println("Inserte un número de tabla correcto");
                                break;
                        }

                    } while (numTabla < 1 || numTabla > 3);
                    break;
                default:
                    System.out.println("Número incorrecto, introduzca de nuevo el número de operación adecuado.");
                    break;
            }
        } while (numOperacion < 1 || numOperacion > 4);

        teclado.close();

    }

    public static void presentacion() {
        System.out.println();
        System.out.println(
                "******************************************* BIENVENIDO A TU CINE **********************************************");
        System.out.println();

        System.out.println(
                "Dentro de este programa podrá eliminar, consultar, modificar o insertar elementos en la base de datos 'cinema'");
        System.out.println();
        System.out.println("A continuación inserte la operacion que quiere realizar:");
        System.out.println();
        System.out.println("1. Insertar   2. Leer    3.Eliminar   4.Modificar");
    }

}
