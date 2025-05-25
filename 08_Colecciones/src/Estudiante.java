//Ejercicio: La Escuela
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Estudiante {
    private final String nombre;
    private final int matricula;
    private int edad;
    private HistoriaAcademica historiaAcademica;

    //Constructores:
    public Estudiante(String nombre, int matricula, int edad){
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.historiaAcademica = new HistoriaAcademica();
    }
    public Estudiante(String nombre, int matricula, int edad, Map<Materia, Set<Double>> historial){
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.historiaAcademica = new HistoriaAcademica(historial);
    }
    public Estudiante(String nombre, int matricula, int edad, HistoriaAcademica historial){
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.historiaAcademica = historial;
    }

    //Dos estudiantes son iguales si tienen la misma matrícula:
    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }

        if(!(otro instanceof Estudiante)){
            return false;
        }

        Estudiante aux = (Estudiante) otro;
        return this.matricula == aux.matricula;
    }
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        String salida = "Alumno " + nombre + "\n"
                + "- Matricula: " + matricula + "\n"
                + "- Edad: " + edad + "\n"
                + historiaAcademica;
        return salida;
    }

    //Getters:
    public String getNombre() {
        return nombre;
    }
    public int getMatricula() {
        return matricula;
    }
    public int getEdad() {
        return edad;
    }
    public HistoriaAcademica getHistoriaAcademica() {
        return historiaAcademica;
    }
}
