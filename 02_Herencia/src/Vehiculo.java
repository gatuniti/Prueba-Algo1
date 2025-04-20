//Ejercicio Alquilando vehiculos
public class Vehiculo {
    private String marca;
    private String modelo;
    private double precioBase;

    public Vehiculo(String marca, String modelo, double precioBase){
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public double calcularCostoAlquiler(int dias){
        return precioBase*dias;
    }
}
