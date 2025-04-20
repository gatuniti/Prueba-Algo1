//Ejercicio Alquilando vehiculos
public class Auto extends Vehiculo{
    public Auto(String marca, String modelo, double precioBase){
        super(marca, modelo, precioBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double alquilerBase = super.calcularCostoAlquiler(dias);
        return alquilerBase*1.20;
    }
}
