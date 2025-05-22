//Ejercicio: Comparación de Estudiantes
package IgualdadOrdenCopia;

public class Estudiante {
    protected final String nombre;
    protected final int edad;
    protected final int matricula;

    public Estudiante(String nombre, int edad, int matricula){
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
        if(!(otro instanceof IgualdadOrdenCopia.Estudiante)){
            return false;
        }
        IgualdadOrdenCopia.Estudiante otroAux = (IgualdadOrdenCopia.Estudiante) otro;
        return this.getNombre() == otroAux.getNombre() &&
                this.getEdad() == otroAux.getEdad();
    }
}
