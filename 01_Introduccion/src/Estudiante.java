//Ejercicio: Crear una clase y un objeto
//Ejercicio: Clase y objeto con miembros estáticos
package Introduccion.src;

public class Estudiante {
    //Variables estáticas
    private static int estudiantesTotales = 0;
    //Variables de instancia
    private String nombre;
    private int edad;
    //public String carrera;
    //public String[] materias;

    //Constructor versión vieja
//    public Estudiante(String nombre, int edad, String carrera, String[] materias){
//        this.nombre = nombre;
//        this.edad = edad;
//        this.carrera = carrera;
//        this.materias = materias;
//    }

    //Constructor
    public Estudiante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //Imprime un mensaje en pantalla que dice el nombre y edad del estudiante
    public void presentarse(){
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }

    //Retorna la cantidad de estudiantes (int)
    public static int getEstudiantesTotales(){
        return estudiantesTotales;
    }

    //Aumenta el numero de estudiantes totales en 1 y
    //retorna un estudiante con el nombre y edad dados
    public static Estudiante agregarEstudiante(String nombre, int edad){
        estudiantesTotales ++;
        return new Estudiante(nombre, edad);
    }

//    public String toString(){
//        return String.format("Nombre: %s%nEdad: %d%nCarrera: %s" +
//                "%nActualmente curzando %d materias", nombre, edad, carrera, materias.length);
//    }
}
