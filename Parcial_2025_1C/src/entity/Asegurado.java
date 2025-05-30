package entity;

import java.time.LocalDateTime;

public class Asegurado {
    private final String nombre;
    private final int dni;
    private final String mail;
    private final String telefono;
    private String plan;
    private LocalDateTime fechaUltimoPago;
    private boolean esMoroso;
    private int cantServiciosActivos = 0;
    private int cantServiciosRealizados = 0;
    private int cantServiciosRechazados = 0;

    public Asegurado(String nombre, int dni, String mail, String telefono, String plan, LocalDateTime fechaUltimoPago){
        this.nombre = nombre;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        this.plan = plan;
        this.fechaUltimoPago = fechaUltimoPago;
        esMoroso = fechaUltimoPago.isBefore(LocalDateTime.now().minusMonths(3));
    }

    public void nuevoServicioSolicitado(){
        cantServiciosActivos++;
    }

    public void terminarSolicitud(Solicitud solicitud, int satisfaccion){
        solicitud.setEstado("realizada");
        solicitud.setSatisfaccion(satisfaccion);
        cantServiciosActivos--;
        cantServiciosRealizados++;
    }

    public void rechazarSolicitud(Solicitud solicitud, String razon){
        solicitud.setEstado("rechazado");
        solicitud.setRazonRechazado(razon);
        cantServiciosActivos--;
        cantServiciosRechazados++;
    }

    public int calcularServiciosSolicitados(){
        return cantServiciosActivos + cantServiciosRealizados + cantServiciosRechazados;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }
        if(!(otro instanceof Asegurado)){
            return false;
        }

        Asegurado aux = (Asegurado) otro;

        return this.dni == aux.dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDateTime getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public boolean esMoroso() {
        return esMoroso;
    }

    public int getCantServiciosActivos() {
        return cantServiciosActivos;
    }

    public int getCantServiciosRealizados() {
        return cantServiciosRealizados;
    }
}
