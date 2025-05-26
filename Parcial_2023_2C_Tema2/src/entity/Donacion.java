package entity;

import java.time.LocalDate;

public class Donacion implements Comparable<Donacion> {
    private final Donante donante;
    private final LocalDate fecha;
    private final double monto;
    private int id;
    private EstadoDonacion estado;

    public Donacion(Donante donante, LocalDate fecha, double monto){
        this.donante = donante;
        this.fecha = fecha;
        this.monto = monto;
        estado = EstadoDonacion.PENDIENTE;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCobrada(){
        estado = EstadoDonacion.COBRADA;
    }

    public void setRechazada(){
        estado = EstadoDonacion.RECHAZADA;
    }

    @Override
    public String toString() {
        String salida = "Donación " + id + "\n" +
                " - Donante: " + donante + "\n" +
                " - Fecha: " + fecha + "\n" +
                " - Estado: " + estado + "\n" +
                " - Monto: " + monto;
        return salida;
    }

    @Override
    public int compareTo(Donacion otro) {
        if(this.fecha == otro.fecha){
            return 0;
        }else if(this.fecha.isBefore(otro.fecha)){
            return -1;
        }else{
            return 1;
        }
    }

    public Donante getDonante() {
        return donante;
    }

    public EstadoDonacion getEstado() {
        return estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public int getId() {
        return id;
    }
}
