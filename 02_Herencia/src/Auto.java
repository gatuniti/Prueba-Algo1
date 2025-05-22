//Ejercicio Alquilando vehiculos
//Ejercicio Corregir el ClassCastException
public class Auto extends Vehiculo{
    public Auto(String marca, String modelo, double precioBase){
        super(marca, modelo, precioBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double alquilerBase = super.calcularCostoAlquiler(dias);
        return alquilerBase*1.20;
    }

    void acelerar() {
        System.out.println("Auto acelerando.");
    }
    void subirVentanas() {
        System.out.println("Subiendo ventanas");
    }
}
