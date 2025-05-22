//Ejercicio "Biblioteca de medios"
public class Libro extends Medio{
    private String autor;

    public Libro(String titulo, String autor){
        super(titulo);
        this.autor = autor;
    }

    @Override
    public void reproducir(){
        System.out.println("Reproduciendo Libro: " + this.titulo + " de " + this.autor);
    }

    public String getAutor(){
        return this.autor;
    }
}
