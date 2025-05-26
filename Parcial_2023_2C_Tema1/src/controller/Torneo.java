package controller;

import entity.Equipo;
import entity.Ordenador;
import entity.Partido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {
    private Map<String, Equipo> equiposParticipantes;
    private List<Partido> partidosJugados;

    public Torneo(){
        equiposParticipantes = new HashMap<>();
        partidosJugados = new ArrayList<>();
    }

    public void cargarEquipo(String nombre, int hinchas) {
        try {
            if(equiposParticipantes.containsKey(nombre)){
                throw new RuntimeException("El equipo que trata cargar ya forma parte de torneo.");
            }
            Equipo equipoNuevo = new Equipo(nombre, hinchas);
            equiposParticipantes.put(nombre, equipoNuevo);
        }catch (RuntimeException exception){
            System.out.println("Error: " + exception);
            System.out.println("Detalle: El equipo es " + nombre);
        }

    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        Equipo equipoLocal = equiposParticipantes.get(local);
        Equipo equipoVisitante = equiposParticipantes.get(visitante);
        Partido partidoNuevo = new Partido(equipoLocal, equipoVisitante, fecha, golesLocal, golesVisitante);
        partidosJugados.add(partidoNuevo);
        partidoNuevo.cargarResultados(golesLocal, golesVisitante);
    }

    public void mostrarPartidosFecha(LocalDate fecha) {
        if(partidosJugados.isEmpty()){
            System.out.println("No se jugaron partidos en la fecha: " + fecha);
        }else{
            for(Partido partido : partidosJugados){
                if(partido.getFecha().isEqual(fecha)){
                    System.out.println(partido);
                }
            }
        }
    }

    public void mostrarTabla() {
        if(equiposParticipantes.isEmpty()){
            System.out.println("Actualmente no hay equipos participando en el torneo, no se puede mostrar una tabla.");
        }else{
            List<Equipo> listaEquipos = new ArrayList<>();
            for(Equipo equipo : equiposParticipantes.values()){
                listaEquipos.add(equipo);
            }
            Ordenador.quickSort(listaEquipos);

            System.out.println("Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG");
            for(Equipo equipo : listaEquipos){
                System.out.println(equipo + " |  " + equipo.calcularPartidosJugados() +
                        " |  " + equipo.getPuntos() + " |  " + equipo.getPartidosGanados() +
                        " |  " + equipo.getPartidosEmpatados() + " |  " + equipo.getPartidosPerdidos() +
                        " |  " + equipo.getGolesConvertidos() + " |  " + equipo.getGolesRecibidos() +
                        " | " + equipo.calcularDiferenciaGoles());
            }
        }
    }

    public Map<String, Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public List<Partido> getPartidosJugados() {
        return partidosJugados;
    }
}
