//Ejercicio: La Escuela
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Escuela {
    private List<Estudiante> listaEstudiantes;
    private Set<String> conjuntoMaterias;

    //Constructores
    public Escuela(){
        listaEstudiantes = new ArrayList<>();
        conjuntoMaterias = new HashSet<>();
    }
    public Escuela(List<Estudiante> listaEstudiantes){
        this.listaEstudiantes = listaEstudiantes;
        conjuntoMaterias = new HashSet<>();
    }
    public Escuela(Set<String> conjuntoMaterias){
        listaEstudiantes = new ArrayList<>();
        this.conjuntoMaterias = conjuntoMaterias;
    }

    public void agregarEstudiante(Estudiante estudiante){
        listaEstudiantes.add(estudiante);
    }
    public void agregarMateria(Materia materia){
        conjuntoMaterias.add(materia.getNombre());
    }
    public void agregarMateria(String materia){
        conjuntoMaterias.add(materia);
    }

    //Getters:
    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public Set<String> getConjuntoMaterias() {
        return conjuntoMaterias;
    }
}
