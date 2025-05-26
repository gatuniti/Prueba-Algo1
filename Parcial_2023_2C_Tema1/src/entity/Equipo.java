package entity;

public class Equipo implements Comparable<Equipo>{
    private final String nombre;
    private int hinchas;
    private int puntos = 0;
    private int partidosGanados = 0;
    private int partidosEmpatados = 0;
    private int partidosPerdidos = 0;
    private int golesConvertidos = 0;
    private int golesRecibidos = 0;

    public Equipo(String nombre, int hinchas){
        this.nombre = nombre;
        this.hinchas = hinchas;
    }

    public void agregarPuntos(int puntos){
        this.puntos += puntos;
    }

    public void agregarPartidoGanado(){
        this.partidosGanados++;
    }

    public void agregarPartidoEmpatado(){
        this.partidosEmpatados++;
    }

    public void agregarPartidoPerdido(){
        this.partidosPerdidos++;
    }

    public void agregarGolesConvertidos(int goles){
        this.golesConvertidos += goles;
    }

    public void agregarGolesRecibidos(int goles){
        this.golesRecibidos += goles;
    }

    public int calcularPartidosJugados(){
        int total = partidosPerdidos + partidosEmpatados + partidosGanados;
        return total;
    }

    public int calcularDiferenciaGoles(){
        int diferencia = golesConvertidos - golesRecibidos;
        return diferencia;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Equipo otro) {
        if(this.puntos == otro.puntos && this.calcularDiferenciaGoles() > otro.calcularDiferenciaGoles()){
            return -1;
        }else if(this.puntos == otro.puntos && this.calcularDiferenciaGoles() < otro.calcularDiferenciaGoles()){
            return 1;
        }else if(this.puntos > otro.puntos){
            return -1;
        }else if(this.puntos < otro.puntos){
            return 1;
        }
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHinchas() {
        return hinchas;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getGolesConvertidos() {
        return golesConvertidos;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }
}
