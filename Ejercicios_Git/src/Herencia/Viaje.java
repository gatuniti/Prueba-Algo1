//public abstract class Viaje {
//    protected String origen;
//    protected String destino;
//    protected double distancia;
//    protected int cantEstaciones;
//    protected int cantVagones;
//    protected int cantMaxPasajeros;
//
//    public Viaje(String origen, String destino, double distancia, int cantEstaciones,
//                 int cantVagones, int cantMaxPasajeros){
//        this.origen = origen;
//        this.destino = destino;
//        this.distancia = distancia;
//        this.cantEstaciones = cantEstaciones;
//        this.cantVagones = cantVagones;
//        this.cantMaxPasajeros = cantMaxPasajeros;
//    }
//
//    public abstract double tiempoDeDemora();
//}

public class Viaje {
    protected String origen;
    protected String destino;
    protected double distancia;
    protected int cantEstaciones;
    protected int cantVagones;
    protected int cantMaxPasajeros;
    protected TipoDeViaje tipoDeViaje;

    public Viaje(String origen, String destino, double distancia, int cantEstaciones,
                 int cantVagones, int cantMaxPasajeros, TipoDeViaje tipoDeViaje){
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.cantEstaciones = cantEstaciones;
        this.cantVagones = cantVagones;
        this.cantMaxPasajeros = cantMaxPasajeros;
        this.tipoDeViaje = tipoDeViaje;
    }

    public double tiempoDeDemora(){
        return tipoDeViaje.calcularDemora(distancia, cantEstaciones, cantMaxPasajeros);
    }
}
