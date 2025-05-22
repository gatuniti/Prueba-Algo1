//Ejercicio "Biblioteca de medios"
public class Musica extends Medio{
    private String artista;

    public Musica(String titulo, String artista){
        super(titulo);
        this.artista = artista;
    }

    @Override
    public void reproducir(){
        System.out.println("Reproduciendo Música: " + this.titulo + " por " + this.artista);
    }

    public String getArtista(){
        return this.artista;
    }
}
