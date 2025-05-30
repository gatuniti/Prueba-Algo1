package entity;

import java.time.LocalDateTime;

public class Solicitud {
    private static int contador = 0;

    private final Asegurado asegurado;
    private final String servicio;
    private final int id;
    private final Prestador prestador;
    private String estado;
    private final LocalDateTime horaAsignada;
    private final LocalDateTime horaEstimadaAtencion;
    private LocalDateTime horaInicioProceso = null;
    private LocalDateTime horaRealizada = null;
    private LocalDateTime horaRechazada = null;
    private int satisfaccion;
    private String razonRechazado;


    public Solicitud(Asegurado asegurado, String servicio, Prestador prestador){
        this.asegurado = asegurado;
        this.servicio = servicio;
        this.prestador = prestador;
        horaAsignada = LocalDateTime.now();
        horaEstimadaAtencion = horaAsignada.plusMinutes(prestador.calcularDemora()); //Hora de solicitud + demora del prestador
        id = contador;
        contador++;
    }

    @Override
    public String toString() {
        String salida = "Solicitud " + id + "\n" +
                " - Asegurado: " + asegurado + "\n" +
                " - Prestador: " + prestador + "\n" +
                " - Servicio: " + servicio + "\n" +
                " - Hora estimada de inicio del servicio: " + horaEstimadaAtencion + "\n" +
                " - Estado: " + estado + "\n" +
                " - Hora que fue asignada: " + horaAsignada;
        if(horaInicioProceso != null){
            salida += "\n - Hora que se inició el proceso de atención: " + horaInicioProceso;
        }
        if(horaRealizada != null){
            salida += "\n - Hora que se finalizó el proceso de atención: " + horaRealizada + "\n" +
            " - Puntuación del asegurado: " + satisfaccion;
        }
        if(horaRechazada != null){
            salida += "\n - Hora que se rechazó la solicitud: " + horaRechazada + "\n" +
            " - Razón por la que se rechazó el servicio: " + razonRechazado;
        }
        return salida;
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }
        if(!(otro instanceof Solicitud)){
            return false;
        }

        Solicitud aux = (Solicitud) otro;

        return this.id == aux.id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getServicio() {
        return servicio;
    }

    public Asegurado getAsegurado() {
        return asegurado;
    }

    public int getId() {
        return id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public LocalDateTime getHoraEstimadaAtencion() {
        return horaEstimadaAtencion;
    }

    public LocalDateTime getHoraInicioProceso() {
        return horaInicioProceso;
    }

    public LocalDateTime getHoraRealizada() {
        return horaRealizada;
    }

    public LocalDateTime getHoraRechazada() {
        return horaRechazada;
    }

    public void setHoraInicioProceso(LocalDateTime horaInicioProceso) {
        this.horaInicioProceso = horaInicioProceso;
    }

    public void setHoraRealizada(LocalDateTime horaRealizada) {
        this.horaRealizada = horaRealizada;
    }

    public void setHoraRechazada(LocalDateTime horaRechazada) {
        this.horaRechazada = horaRechazada;
    }

    public int getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(int satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    public String getRazonRechazado() {
        return razonRechazado;
    }

    public void setRazonRechazado(String razonRechazado) {
        this.razonRechazado = razonRechazado;
    }

    public LocalDateTime getHoraAsignada() {
        return horaAsignada;
    }
}
