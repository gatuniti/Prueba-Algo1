//Ejercicio: Comparación de Estudiantes
package IgualdadOrdenCopia;

public class EstudiantePosgrado extends EstudianteIg{
    private final String carreraPosgrado;

    public EstudiantePosgrado(String nombre, String carreraPosgrado, int edad, int matricula){
        super(nombre, edad, matricula);
        this.carreraPosgrado = carreraPosgrado;
    }

    public String getCarreraPosgrado(){
        return carreraPosgrado;
    }

    @Override
    public boolean equals(Object otro){
        if(this == otro){
            return true;
        }
        if(!(otro instanceof EstudiantePosgrado)){
            return false;
        }
        EstudiantePosgrado otroAux = (EstudiantePosgrado) otro;
        return this.getNombre() == otroAux.getNombre() &&
                this.getEdad() == otroAux.getEdad() &&
                this.getMatricula() == otroAux.getMatricula() &&
                this.getCarreraPosgrado() == otroAux.getCarreraPosgrado();
    }
}
