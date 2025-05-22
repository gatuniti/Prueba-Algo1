//Ejercicio: Comparación de Estudiantes
public class EstudianteGrado extends Estudiante {
    private final String carreraGrado;

    public EstudianteGrado(String nombre, String carreraGrado, int edad, int matricula){
        super(nombre, edad, matricula);
        this.carreraGrado = carreraGrado;
    }

    public String getCarreraGrado(){
        return carreraGrado;
    }

    @Override
    public boolean equals(Object otro){
        if(this == otro){
            return true;
        }
        if(!(otro instanceof EstudianteGrado)){
            return false;
        }
        EstudianteGrado otroAux = (EstudianteGrado) otro;
        return this.getNombre() == otroAux.getNombre() &&
                this.getEdad() == otroAux.getEdad() &&
                this.getMatricula() == otroAux.getMatricula() &&
                this.getCarreraGrado() == otroAux.getCarreraGrado();
    }
}
