//Ejercicio: Arreglo de inmutables
package IgualdadOrdenCopia;

import java.time.LocalDate;

public class Documento {
    private final int numeroDoc;
    private final LocalDate fechaEmicion;
    private final LocalDate fechaVencimiento;

    public Documento(int numeroDoc){
        this.numeroDoc = numeroDoc;
        this.fechaEmicion = LocalDate.now();
        this.fechaVencimiento = this.fechaEmicion.plusYears(10);
    }

    public Documento renovarDocumento(){
        return new Documento(numeroDoc);
    }

    public int getNumeroDoc() {
        return numeroDoc;
    }
}
