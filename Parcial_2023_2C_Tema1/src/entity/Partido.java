package entity;

import java.time.LocalDate;

public class Partido {
    private final Equipo local;
    private final Equipo visitante;
    private final LocalDate fecha;
    private final int golesLocal;
    private final int golesVisitante;

    public Partido(Equipo local, Equipo visitante, LocalDate fecha, int golesLocal, int golesVisitante){
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public void cargarResultados(int golesLocal, int golesVisitante){
        local.agregarGolesConvertidos(golesLocal);
        local.agregarGolesRecibidos(golesVisitante);
        visitante.agregarGolesConvertidos(golesVisitante);
        visitante.agregarGolesRecibidos(golesLocal);

        if(golesLocal == golesVisitante){
            local.agregarPuntos(1);
            local.agregarPartidoEmpatado();
            visitante.agregarPuntos(1);
            visitante.agregarPartidoEmpatado();
        }else if(golesLocal > golesVisitante){
            local.agregarPuntos(3);
            local.agregarPartidoGanado();
            visitante.agregarPartidoPerdido();
        }else{
            visitante.agregarPuntos(3);
            local.agregarPartidoPerdido();
            visitante.agregarPartidoGanado();
        }
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", " + local + " (" + golesLocal + ") - " + visitante + " (" + golesVisitante + ")";
    }

    public Equipo getEquipoLocal(){
        return local;
    }

    public Equipo getEquipoVisitante(){
        return visitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
}
