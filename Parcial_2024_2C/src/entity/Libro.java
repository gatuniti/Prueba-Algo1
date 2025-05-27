package entity;

public class Libro {
    private final String nombre;
    private final String autor;
    private boolean esUnico;
    private EstadoLibro estado;

    public Libro(String nombre, String autor, boolean esUnico){
        this.nombre = nombre;
        this.autor = autor;
        this.esUnico = esUnico;
        estado = EstadoLibro.DISPONIBLE;
    }

    public void setEsUnico(boolean esUnico) {
        this.esUnico = esUnico;
    }

    public void sePresto(){
        estado = EstadoLibro.PRESTADO;
    }

    public void seDevolvio(){
        estado = EstadoLibro.DISPONIBLE;
    }

    @Override
    public String toString() {
        String salida = nombre + " - " + autor;
        return salida;
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }
        if(!(otro instanceof Libro)){
            return false;
        }
        Libro aux = (Libro) otro;
        return this.nombre == aux.nombre && this.autor == aux.autor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public boolean esUnico() {
        return esUnico;
    }

    public EstadoLibro getEstado() {
        return estado;
    }
}
