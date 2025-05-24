package controller;

import entity.Estudio;
import entity.Paciente;
import entity.Profesional;
import entity.Receta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private final String nombre;
    Map<Integer, Profesional> profesionales;
    Map<Integer, Paciente> pacientes;
    List<Receta> recetas;

    public Hospital(String nombre){
        this.nombre = nombre;
        profesionales = new HashMap<>();
        pacientes = new HashMap<>();
        recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String nombre, int matricula) {
        if(profesionales.containsKey(matricula)){
            throw new RuntimeException("No se puede registrar un profesional con una matrícula repetida.");
        }
        Profesional nuevoProfesional = new Profesional(nombre, matricula);
        profesionales.put(matricula, nuevoProfesional);
        return nuevoProfesional;
    }

    public Paciente registrarPaciente(String nombre, int dni) {
        if(pacientes.containsKey(dni)){
            throw new RuntimeException("No se puede registrar un paciente con un dni repetido.");
        }
        Paciente nuevoPaciente = new Paciente(nombre, dni);
        pacientes.put(dni, nuevoPaciente);
        return nuevoPaciente;
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        if(!(profesionales.containsKey(profesional.getMatricula()))){
            throw new RuntimeException("Profesional no registrado.");
        }
        if(!(pacientes.containsKey(paciente.getDni()))){
            throw new RuntimeException("Paciente no registrado.");
        }
        Receta nuevaReceta = new Receta(profesional, paciente, estudios);
        recetas.add(nuevaReceta);
        return nuevaReceta;
    }

    public void procesar(Receta receta) {
        if(receta.isProcesado()){
            throw new IllegalStateException("La receta ya está procesada.");
        }
        for(Receta rec : recetas){
            if(receta.equals(rec)){
                receta.procesar();

            }
        }

    }

    public void mostrarRecetas() {
        System.out.println("Recetas de " + nombre + ":");
        for(Receta rec : recetas){
            System.out.println(rec);
            for(Estudio estudio : rec.getEstudios()){
                System.out.println(estudio);
            }
        }
    }

    public void mostrarRecetasProcesadas() {
        System.out.println("Recetas procesadas de " + nombre + ":");
        for(Receta rec : recetas){
            if(rec.isProcesado()){
                System.out.println(rec);
                for(Estudio estudio : rec.getEstudios()){
                    System.out.println(estudio);
                }
            }
        }
    }

    public void mostrarPacientesConEstudios(int minimoEstudiosRealizados) {
        System.out.println("Pacientes con al menos " + minimoEstudiosRealizados +
                " estudios realizados en " + nombre + ":");
        for(Paciente paciente : pacientes.values()){
            if(paciente.getCantidadEstudiosRealizados() >= minimoEstudiosRealizados){
                System.out.println(paciente);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
}
