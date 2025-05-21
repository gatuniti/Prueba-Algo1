//Ejercicio "Biblioteca de medios"
package Polimorfismo;

public class Medio {
    protected String titulo;

    public Medio(String titulo){
        this.titulo = titulo;
    }

    public void reproducir(){
        System.out.println("Reproduciendo medio genérico: " + this.titulo);
    }

    public String getTitulo(){
        return this.titulo;
    }
}
