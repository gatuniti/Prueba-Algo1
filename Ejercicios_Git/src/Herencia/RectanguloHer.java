//Ejercicio Figuras geométricas
public class RectanguloHer extends Figura{
    private double base;
    private double altura;

    public RectanguloHer(double base, double altura){
        super("Rectangulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base*altura;
    }
}
