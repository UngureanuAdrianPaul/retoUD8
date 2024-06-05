import CRUD.MiCrud;
import supplier.Supplier;
import tablas.Cine;
import tablas.Pelicula;
import tablas.Sala;

public class App {
    public static void main(String[] args) {

        Supplier suministrador = new Supplier("cinema");
        Cine cine1 = new Cine("Calle Blas Infante", "Teatro Real", 1);
        Cine cine2 = new Cine("Calle Senador Gaspar", "Lope de Vega", 2);
        Sala sala1 = new Sala(1, 200, 10);
        Pelicula peli1 = new Pelicula(0, "Inception", 200, "Explota-cabezas", "El Nolan", "+10", 10);

        
        suministrador.insert(cine1);
        suministrador.insert(cine2);

        Cine[] vista = suministrador.readCine();

        
        System.out.println(vista.length);
        // Cine[] cines = new Cine[vista.length];

        for (Cine cine : vista) {
            System.out.println(cine);
        }
        

        // for (int i = 0; i < cines.length; i++) {

        // }
        // String[] elemento1 = new String[3];
        

        // for (int i = 0; i < vista.length; i++) {
        //     int primero = vista[i].indexOf(MiCrud.SEPARADOR);
        //     elemento1[i] = vista[i].substring(0, primero);
        //     System.out.println(elemento1[i]);

        //     elemento1[i] = vista[i].substring(primero + 3, vista[i].indexOf(MiCrud.SEPARADOR, primero +3));
        //     System.out.println(elemento1[i]);
            
        //     elemento1[i] = vista[i].substring( vista[i].indexOf(MiCrud.SEPARADOR, primero +3) + 3);
        //     System.out.println(elemento1[i]);
        // }

    }
}
