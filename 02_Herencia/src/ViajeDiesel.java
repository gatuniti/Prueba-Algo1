//public class ViajeDiesel extends Viaje{
//    public ViajeDiesel(String origen, String destino, double distancia, int cantEstaciones,
//                       int cantVagones, int cantMaxPasajeros){
//        super(origen, destino, distancia, cantEstaciones, cantVagones, cantMaxPasajeros);
//    }
//
//    @Override
//    public double tiempoDeDemora() {
//        return distancia*cantEstaciones/2+cantEstaciones+cantMaxPasajeros/10;
//    }
//}

public class ViajeDiesel implements TipoDeViaje{
    @Override
    public double calcularDemora(double distancia, int cantEstaciones, int cantMaxPasajeros) {
        return distancia*cantEstaciones/2+cantEstaciones+cantMaxPasajeros/10;
    }
}
