//Ejercicio: Arreglo de inmutables
package IgualdadOrdenCopia;

import java.time.LocalDate;

public class Documento {
    private final int numeroDoc;
    private LocalDate fechaEmicion;
    private LocalDate fechaVencimiento;

    public Documento(int numeroDoc){
        this.numeroDoc = numeroDoc;
        this.fechaEmicion = LocalDate.now();
        this.fechaVencimiento = this.fechaEmicion.plusYears(10);
    }

    public Documento renovarDocumento(){
        return new Documento(numeroDoc);
    }

    @Override
    public String toString(){
        return "DNI: " + numeroDoc + " Fecha de emición: " + fechaEmicion + " Fecha de vencimiento: " + fechaVencimiento;
    }

    public void setFechas(LocalDate nuevaFecha){
        this.fechaEmicion = nuevaFecha;
        this.fechaVencimiento = nuevaFecha.plusYears(10);
    }
}
