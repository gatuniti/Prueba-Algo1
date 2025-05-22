//Ejercicio: Clases y métodos
public class RectanguloIntro {
    private double largo;
    private double ancho;

    public RectanguloIntro(double largo, double ancho){
        this.largo = largo;
        this.ancho = ancho;
    }

    public double calcularArea(){
        return largo*ancho;
    }

    public double calcularPerimetro(){
        return largo*2+ancho*2;
    }
}
