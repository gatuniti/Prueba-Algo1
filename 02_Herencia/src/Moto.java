//Ejercicio Alquilando vehiculos
public class Moto extends Vehiculo{
    public Moto(String marca, String modelo, double precioBase){
        super(marca, modelo, precioBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double alquilerBase = super.calcularCostoAlquiler(dias);
        return alquilerBase*0.85;
    }
}
