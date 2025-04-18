//Ejercicio: Crear una clase y un objeto
//Ejercicio: Clase y objeto con miembros estáticos
package Introduccion.src;

import java.util.ArrayList;

public class Estudiante {
    private static int estudiantesTotales = 0;

    private String nombre;
    private int edad;
    //public String carrera;
    //public String[] materias;


//    public Estudiante(String nombre, int edad, String carrera, String[] materias){
//        this.nombre = nombre;
//        this.edad = edad;
//        this.carrera = carrera;
//        this.materias = materias;
//    }

    public Estudiante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void presentarse(){
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }

    public static int getEstudiantesTotales(){
        return estudiantesTotales;
    }

    public static Estudiante agregarEstudiante(String nombre, int edad){
        estudiantesTotales ++;
        return new Estudiante(nombre, edad);
    }

//    public String toString(){
//        return String.format("Nombre: %s%nEdad: %d%nCarrera: %s" +
//                "%nActualmente curzando %d materias", nombre, edad, carrera, materias.length);
//    }
}
