//public class ViajeElectrico extends Viaje{
//    public ViajeElectrico(String origen, String destino, double distancia, int cantEstaciones,
//                       int cantVagones, int cantMaxPasajeros){
//        super(origen, destino, distancia, cantEstaciones, cantVagones, cantMaxPasajeros);
//    }
//
//    @Override
//    public double tiempoDeDemora() {
//        return distancia*cantEstaciones/2;
//    }
//}

public class ViajeElectrico implements TipoDeViaje{
    @Override
    public double calcularDemora(double distancia, int cantEstaciones, int cantMaxPasajeros) {
        return distancia*cantEstaciones/2;
    }
}