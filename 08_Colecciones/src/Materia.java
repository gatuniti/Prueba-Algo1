//Ejercicio: La Escuela
import java.util.Objects;

public class Materia {
    private final String nombre;
    private final int codigo;
    private boolean estado;

    //Constructor:
    public Materia(String nombre, int codigo, boolean estado){
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
    }

    public void abrirMateria(){
        this.estado = true;
    }

    public void cerrarMateria(){
        this.estado = false;
    }

    //Dos materias son iguales si tienen el mismo código:
    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }

        if(!(otro instanceof Materia)){
            return false;
        }

        Materia aux = (Materia) otro;
        return this.codigo == aux.codigo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        String salida = "Materia: " + nombre + ";\n" +
                "- Código: " + codigo + ";\n" +
                "- Estado: " + (estado ? "abierta." : "cerrada.");

        return salida;
    }

    //Getters:
    public String getNombre() {
        return nombre;
    }
    public int getCodigo() {
        return codigo;
    }
    public boolean isAbierta() {
        return estado;
    }
}
