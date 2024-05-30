import CRUD.MiCrud;

public class App {
    public static void main(String[] args) {

        MiCrud miAcceso = new MiCrud("cinema");

        miAcceso.insertRow("cines", new String[] { "direccion", "identificador", "nombre_del_cine" },
                new Object[] { "Calle Blas Infante", 2, "Lope de Vega" });

        
    }
}
