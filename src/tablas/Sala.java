package tablas;

public class Sala {
    

    private int identificadorSala;
    private int capacidad;
    private double metrosCuadrados;

    
    public Sala() {
        this.identificadorSala = -1;
        this.capacidad = -1;
        this.metrosCuadrados = -1;
    }


    public Sala(int identificadorSala, int capacidad, double metrosCuadrados) {
        this.identificadorSala = identificadorSala;
        this.capacidad = capacidad;
        this.metrosCuadrados = metrosCuadrados;
    }


    public int getIdentificadorSala() {
        return identificadorSala;
    }


    public void setIdentificadorSala(int identificadorSala) {
        this.identificadorSala = identificadorSala;
    }


    public int getCapacidad() {
        return capacidad;
    }


    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }


    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Sala [identificadorSala=" + identificadorSala + ", capacidad=" + capacidad + ", metrosCuadrados="
                + metrosCuadrados + "]";
    }

    
    

    
}
