//Ejercicio "Biblioteca de medios"
package Polimorfismo;

public class Pelicula extends Medio{
    private String director;

    public Pelicula(String titulo, String director){
        super(titulo);
        this.director = director;
    }

    @Override
    public void reproducir(){
        System.out.println("Reproduciendo Película: " + this.titulo + " dirigida por " + this.director);
    }

    public String getDirector(){
        return this.director;
    }
}
