//Ejercicio Figuras geométricas
public abstract class Figura {
    private String nombre;

    public Figura(String nombre){
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public String getNombre(){
        return this.nombre;
    }
}
