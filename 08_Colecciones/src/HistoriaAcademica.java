//Ejercicio: La Escuela
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HistoriaAcademica {
    //Diccionarios con las materias como claves y un conjunto de doubles (calificaciones) como valores:
    private Map<Materia, Set<Double>> historial;

    //Constructores:
    public HistoriaAcademica(){
        this.historial = new HashMap<>();
    }
    public HistoriaAcademica(Map<Materia, Set<Double>> historial){
        this.historial = historial;
    }

    public void agregarCalificacion(Materia materia, double calificacion){
        historial.putIfAbsent(materia, new HashSet<>());
        historial.get(materia).add(calificacion);
    }

    //Funciones que calculan promedios:
    public double calcularPromedioMateria(Materia materia){
        Set<Double> calificaciones = historial.get(materia);
        int cantCalificaciones = calificaciones.size();
        double sumaCalificaciones = 0;

        for(double calificacion : calificaciones){
            sumaCalificaciones += calificacion;
        }

        return sumaCalificaciones/cantCalificaciones;
    }
    public double calcularPromedioGeneral(){
        int cantMaterias = historial.size();
        double sumaPromedios = 0;

        for(Materia materia : historial.keySet()){
            sumaPromedios += calcularPromedioMateria(materia);
        }

        return sumaPromedios/cantMaterias;
    }

    //Funciones que calculan la cantidad de aplazos:
    public int cantidadAplazosMateria(Materia materia){
        Set<Double> calificaciones = historial.get(materia);
        int cantAplazos = 0;

        for(double calificacion : calificaciones){
            if(calificacion < 2){
                cantAplazos++;
            }
        }

        return cantAplazos;
    }
    public int cantidadAplazosGeneral(){
        int cantAplazos = 0;

        for(Materia materia : historial.keySet()){
            cantAplazos += cantidadAplazosMateria(materia);
        }

        return cantAplazos;
    }

    public int cantidadMateriasCursadas(){
        int cantMaterias = 0;

        for(Materia materia : historial.keySet()){
            if(!(historial.get(materia).isEmpty())){
                cantMaterias++;
            }
        }

        return cantMaterias;
    }

    @Override
    public String toString() {
        String salida = "- Materias: \n";
        for(Materia materia : historial.keySet()){
            salida += " - " + materia.getNombre() + ": " + calcularPromedioMateria(materia) + "\n";
        }
        return salida;
    }

    //Getter:
    public Map<Materia, Set<Double>> getHistorial() {
        return historial;
    }
}
