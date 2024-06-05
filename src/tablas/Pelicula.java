package tablas;

public class Pelicula {

    private int identificadorPelicula;
    private String titulo;
    private int duracionMinutos;
    private String genero;
    private String director;
    private String clasificacionPorEdad;
    private double precio;

    public Pelicula(int identificadorPelicula, String titulo, int duracionMinutos, String genero, String director,
            String clasificacionPorEdad, double precio) {
        this.identificadorPelicula = identificadorPelicula;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.director = director;
        this.clasificacionPorEdad = clasificacionPorEdad;
        this.precio = precio;
    }

    public Pelicula() {

        this.identificadorPelicula = -1;
        this.titulo = null;
        this.duracionMinutos = -1;
        this.genero = null;
        this.director = null;
        this.clasificacionPorEdad = null;
        this.precio = -1;
    }

    public int getIdentificadorPelicula() {
        return identificadorPelicula;
    }

    public void setIdentificadorPelicula(int identificadorPelicula) {
        this.identificadorPelicula = identificadorPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getClasificacionPorEdad() {
        return clasificacionPorEdad;
    }

    public void setClasificacionPorEdad(String clasificacionPorEdad) {
        this.clasificacionPorEdad = clasificacionPorEdad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //TOSTRING
    
    @Override
    public String toString() {
        return "Pelicula [identificadorPelicula=" + identificadorPelicula + ", titulo=" + titulo + ", duracionMinutos="
                + duracionMinutos + ", genero=" + genero + ", director=" + director + ", clasificacionPorEdad="
                + clasificacionPorEdad + ", precio=" + precio + "]";
    }

    
    

}
