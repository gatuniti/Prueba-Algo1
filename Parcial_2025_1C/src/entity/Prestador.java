package entity;

import java.util.*;

public class Prestador {
    private final String nombre;
    private final String cuit;
    private final String mail;
    private final String telefono;
    private List<String> servicios;
    private Deque<Solicitud> colaTrabajo;

    public Prestador(String nombre, String cuit, String mail, String telefono, List<String> servicios){
        this.nombre = nombre;
        this.cuit = cuit;
        this.mail = mail;
        this.telefono = telefono;
        this.servicios = servicios;
        colaTrabajo = new LinkedList<>();
    }

    public void asignarTrabajo(Solicitud solicitud){
        if(solicitud.getAsegurado().getPlan() == "lujo"){
            colaTrabajo.addFirst(solicitud);
        }else{
            colaTrabajo.addLast(solicitud);
        }
        solicitud.setEstado("asignada");
    }

    //Devuelve la demora en minutos que tiene un prestador para dar un nuevo servicio.
    public int calcularDemora(){
        int demora = 0;
        for(Solicitud solicitud : colaTrabajo){
            switch (solicitud.getServicio()){
                case "acarreo": demora += 40;
                break;
                case "bateria": demora += 15;
                break;
                case "neumatico": demora += 30;
                break;
                case "mecanica_ligera": demora += 60;
                break;
            }
        }
        return demora;
    }

    public void iniciaSolicitud(Solicitud solicitud){
        solicitud.setEstado("en proceso");
    }

    public void terminarSolicitud(Solicitud solicitud){
        colaTrabajo.remove(solicitud);
    }

    @Override
    public String toString() {
        return nombre + " (" + cuit + ")";
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }
        if(!(otro instanceof Prestador)){
            return false;
        }

        Prestador aux = (Prestador) otro;

        return this.cuit == aux.cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<String> getServicios() {
        return servicios;
    }
}
