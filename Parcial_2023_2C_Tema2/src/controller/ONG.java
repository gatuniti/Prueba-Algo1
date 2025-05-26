package controller;

import entity.Calculador;
import entity.Donacion;
import entity.Donante;
import entity.EstadoDonacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ONG {
    private final String nombre;
    private Map<String, Donante> donantes;
    private List<Donacion> donaciones;

    public ONG(String nombre){
        this.nombre = nombre;
        donantes = new HashMap<>();
        donaciones = new ArrayList<>();
    }

    public Donante registrarDonante(String nombre, String apellido) {
        try {
            //Verifico que el donante no esté ya registrado:
            if(donantes.containsKey(nombre+apellido)){
                throw new RuntimeException("El donante " + nombre + " " + apellido +" ya está registrado.");
            }
            //Registro el donante nuevo:
            Donante donanteNuevo = new Donante(nombre, apellido);
            donantes.put(nombre+apellido, donanteNuevo);
            donanteNuevo.setId(donantes.size());
            return donanteNuevo;
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception);
        }
        return null;
    }

    public Donacion cargarDonacion(Donante donante, LocalDate fecha, int monto) {
        Donacion donacionNueva = new Donacion(donante, fecha, monto);
        donaciones.add(donacionNueva);
        donacionNueva.setId(donaciones.size());
        return donacionNueva;
    }

    public void mostrarDonantes() {
        if(donantes.isEmpty()){
            System.out.println(nombre + " no tiene donantes registrados.");
        }else{
            System.out.println("Listado de donantes de " + nombre);
            for(Donante donante : donantes.values()){
                System.out.println(donante);
            }
        }

    }

    public void mostrarDonaciones() {
        if(donaciones.isEmpty()){
            System.out.println(nombre + " no tiene donciones registradas.");
        }else{
            Collections.sort(donaciones);
            System.out.println("Listado de donaciones de " + nombre);
            for(Donacion donacion : donaciones){
                System.out.println(donacion);
            }
        }
    }

    public void mostrarResultadoFecha(LocalDate fecha) {
        if(donaciones.isEmpty()){
            System.out.println(nombre + " no tiene donciones registradas.");
        }else{
            System.out.println("Estado de Resultado de " + nombre + " al " + fecha);

            Map<String, Number> resultados = new HashMap<>();
            Calculador.calcularResultadoFecha(fecha, donaciones, resultados);
            System.out.println(" - Cobradas: " + resultados.get("cobradas"));
            System.out.println(" - Rechazadas: " + resultados.get("rechazadas"));
            System.out.println(" - Pendientes: " + resultados.get("pendientes"));
            if(resultados.get("cobradas").intValue() > 0){
                System.out.println(" - Monto Total: $ " + resultados.get("total"));
                System.out.println(" - Monto máximo: $ " + resultados.get("maximo"));
                System.out.println(" - Monto mínimo: $ " + resultados.get("minimo"));
                System.out.println(" - Monto medio: $ " + resultados.get("total").doubleValue()/resultados.get("cobradas").intValue());
            }
        }
    }
}
