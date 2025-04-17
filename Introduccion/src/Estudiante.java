package Introduccion.src;

import java.util.ArrayList;

public class Estudiante {
    public String nombre;
    public int edad;
    public String carrera;
    public ArrayList<String> materias;

    public Estudiante(String nombre, int edad, String carrera, ArrayList<String> materias){
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.materias = materias;
    }

    public String toString(){
        return String.format("Nombre: %s, Edad: %d, Carrera: %s", nombre, edad, carrera);
    }
}
