package tablas;

public class Cine {

    // attributes

    private String direccion;
    private String nombreCine;
    private int identificadorCine;

    // constructor
    public Cine(String direccion, String nombreDelCine, int identificador) {
        this.direccion = direccion;
        this.nombreCine = nombreDelCine;
        this.identificadorCine = identificador;
    }

    public Cine() {
        this.direccion = null;
        this.nombreCine = null;
        this.identificadorCine = -1;
    }

    //GETTERS Y SETTERS
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public int getIdentificadorCine() {
        return identificadorCine;
    }

    public void setIdentificadorCine(int identificadorCine) {
        this.identificadorCine = identificadorCine;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Cine [direccion=" + direccion + ", nombreCine=" + nombreCine + ", identificadorCine="
                + identificadorCine + "]";
    }
    
    

}
