//Ejercicio: Comparación de Estudiantes
package IgualdadOrdenCopia;

public class EstudianteIg {
    protected final String nombre;
    protected final int edad;
    protected final int matricula;

    public EstudianteIg(String nombre, int edad, int matricula){
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object otro){
        if(this == otro){
            return true;
        }
        if(!(otro instanceof EstudianteIg)){
            return false;
        }
        EstudianteIg otroAux = (EstudianteIg) otro;
        return this.getNombre() == otroAux.getNombre() &&
                this.getEdad() == otroAux.getEdad();
    }
}
