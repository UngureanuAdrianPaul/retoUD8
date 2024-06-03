package tablas;
import CRUD.MiCrud;
public class Salas {
    
    //attributes

    private String direccion;
    private String nombreDelCine;
    private int identificadorSala;
    
    //constructor
    public Salas(String direccion, String nombreDelCine, int identificador) {
        this.direccion = direccion;
        this.nombreDelCine = nombreDelCine;
        this.identificadorSala = identificador;
    }

    public Salas(){
        this.direccion = null;
        this.nombreDelCine = null;
        this.identificadorSala= 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreDelCine() {
        return nombreDelCine;
    }

    public int getIdentificadorSala() {
        return identificadorSala;
    }

    //metodos de CRUD

    public boolean insertarCine(){

        
        return true;
    }


}
