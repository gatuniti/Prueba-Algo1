//public class ViajeAltaVelocidad extends Viaje{
//    public ViajeAltaVelocidad(String origen, String destino, double distancia,
//                              int cantEstaciones, int cantVagones, int cantMaxPasajeros){
//        super(origen, destino, distancia, cantEstaciones, cantVagones, cantMaxPasajeros);
//    }
//
//    @Override
//    public double tiempoDeDemora() {
//        return distancia/10;
//    }
//}

public class ViajeAltaVelocidad implements TipoDeViaje{
    @Override
    public double calcularDemora(double distancia, int cantEstaciones, int cantMaxPasajeros) {
        return distancia/10;
    }
}