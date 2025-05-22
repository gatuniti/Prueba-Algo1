//Ejercicio: Constructores de libro
import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = LocalDate.now().getYear();
    }

    public Libro(String titulo, String autor, int añoPublicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    public String toString(){
        return String.format("Nombre: %s%nAutor: %s%nAño de publicación: %d",
                titulo, autor, añoPublicacion);
    }
}
