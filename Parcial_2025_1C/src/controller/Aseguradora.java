package controller;

import entity.Asegurado;
import entity.Prestador;
import entity.Solicitud;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aseguradora {
    private final String nombre;
    private Map<String, Prestador> prestadores;
    private Map<Integer, Asegurado> asegurados;
    private List<Solicitud> solicitudes;

    public Aseguradora(String nombre){
        this.nombre = nombre;
        prestadores = new HashMap<>();
        asegurados = new HashMap<>();
        solicitudes = new ArrayList<>();
    }

    public Prestador registrarPrestador(String nombre, String cuit, String mail, String telefono, List<String> servicios) {
        try {
            //Me fijo que el prestador no se haya registrado antes:
            if(prestadores.containsKey(cuit)){
                throw new RuntimeException("El prestador " + nombre + " (" + cuit + ") ya está registrado en el sistema.");
            }

            Prestador prestadorNuevo = new Prestador(nombre, cuit, mail, telefono, servicios);
            prestadores.put(cuit, prestadorNuevo);
            return prestadorNuevo;
        }catch (RuntimeException exception){
            System.out.println(exception);
            return null;
        }
    }

    public Asegurado registrarAsegurado(String nombre, int dni, String mail, String telefono, String plan, LocalDateTime fechaUltimoPago) {
        try {
            //Me fijo que el asegurado no se haya registrado antes:
            if(prestadores.containsKey(dni)){
                throw new RuntimeException("El asegurado " + nombre + " (" + dni + ") ya está registrado en el sistema.");
            }

            Asegurado aseguradoNuevo = new Asegurado(nombre, dni, mail, telefono, plan, fechaUltimoPago);
            asegurados.put(dni, aseguradoNuevo);
            return aseguradoNuevo;
        }catch (RuntimeException exception){
            System.out.println(exception);
            return null;
        }
    }

    public Solicitud solicitar(Asegurado asegurado, String servicio) {
        //Me fijo que los asegurados del plan "tranquilo" no hayan solicitado 2 servicios este mes:
        if(asegurado.getPlan() == "tranquilo" && calcularSolicitudesMes(asegurado) == 2){
            throw new RuntimeException("El asegurado " + asegurado + " ha excedido la cantidad de servicios que puede solicitar según su plan.");
        }
        //Me fijo que el asegurado no sea moroso:
        if(asegurado.esMoroso()){
            throw new RuntimeException("El asegurado " + asegurado + " debe regularizar su cuenta con vencimiento: " + asegurado.getFechaUltimoPago().plusMonths(3));
        }

        Prestador prestadorAsignado = asignarPrestadorAServicio(servicio);

        Solicitud solicitudNueva = new Solicitud(asegurado, servicio, prestadorAsignado);
        solicitudes.add(solicitudNueva);
        prestadorAsignado.asignarTrabajo(solicitudNueva);
        asegurado.nuevoServicioSolicitado();

        return solicitudNueva;
    }

    //Calculo la cantidad de solicitudes que realizó un asegurado en el mes.
    public int calcularSolicitudesMes(Asegurado asegurado){
        int cantSolicitudesMes = 0;
        for(Solicitud solicitud : solicitudes){
            if(solicitud.getAsegurado() == asegurado &&
                    solicitud.getHoraAsignada().getMonth() == LocalDateTime.now().getMonth()){
                cantSolicitudesMes++;

            }
        }
        return cantSolicitudesMes;
    }

    //Devuelve el prestador que pueda dar ese servicio con menos solicitudes en su cola de trabajo:
    public Prestador asignarPrestadorAServicio(String servicio){
        List<Prestador> prestadoresServicio = new ArrayList<>();
        getPrestadoresServicio(servicio, prestadoresServicio);
        int cantServicios = prestadoresServicio.get(0).getServicios().size();
        int index = 0;
        for(int i = 1; i < prestadoresServicio.size(); i++){
            if(cantServicios > prestadoresServicio.get(i).getServicios().size()){
                cantServicios = prestadoresServicio.get(i).getServicios().size();
                index = i;
            }
        }

        Prestador prestadorAsignado = prestadoresServicio.get(index);
        return prestadorAsignado;
    }

    public void getPrestadoresServicio(String servicio, List<Prestador> prestadoresServicio){
        for(Prestador prestador : prestadores.values()){
            if(prestador.getServicios().contains(servicio)){
                prestadoresServicio.add(prestador);
            }
        }
    }

    public void llegoAlSitioDeAtencion(Solicitud solicitud) {
        solicitud.getPrestador().iniciaSolicitud(solicitud);
        solicitud.setHoraInicioProceso(LocalDateTime.now());
    }

    public void atencionRealizada(Solicitud solicitud, int satisfaccion) {
        try{
            //Reviso que los puntos de satisfacción estén dentro de [1;5]:
            if(satisfaccion < 1 || satisfaccion > 5){
                throw new IllegalArgumentException("Los puntos de satisfacción van del 1 al 5, " + satisfaccion + "no entra en ese rango.");
            }

            solicitud.getAsegurado().terminarSolicitud(solicitud, satisfaccion);
            solicitud.setHoraRealizada(LocalDateTime.now());
            solicitud.getPrestador().terminarSolicitud(solicitud);

        }catch (IllegalArgumentException exception){
            System.out.println(exception);
        }
    }

    public void solicitudRechazada(Solicitud solicitud, String razon) {
        solicitud.getAsegurado().rechazarSolicitud(solicitud, razon);
        solicitud.setHoraRechazada(LocalDateTime.now());
    }

    public void listarSolicitudes() {
        for(Solicitud solicitud : solicitudes){
            System.out.println(solicitud);
        }
    }

    public void listarSolicitudesEnEspera() {
        for(Solicitud solicitud : solicitudes){
            if(solicitud.getEstado() == "asignada"){
                System.out.println(solicitud);
            }
        }
    }

    /*
        En el pdf dice "mostrar asegurados con al menos 3 solicitudes" no especifica el estado,
        por lo que voy a mostrar por pantalla los asegurados que hayan hecho al menos 3 solicitudes
        sin importar el estado.
        Si lo hago con solicitudes realizadas, no me muestra nadie con este main de ejemplo ya que no hay ningún
        asegurado con 3 solicitudes realizadas. El máximo es pepe, con 2.
    */
    public void mostrarAseguradosConAlMenosSolicitudes(int cantidad) {
        for(Asegurado asegurado : asegurados.values()){
            if(asegurado.calcularServiciosSolicitados() >= cantidad){
                System.out.println(asegurado);
            }
        }
    }
}
