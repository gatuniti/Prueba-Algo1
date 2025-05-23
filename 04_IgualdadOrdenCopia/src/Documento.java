//Ejercicio: Arreglo de inmutables
//Ejercicio: Copia profunda sin Cloneable
import java.time.LocalDate;

public class Documento implements Cloneable{
    private int numeroDoc;
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

    public int getNumeroDoc(){
        return this.numeroDoc;
    }

    public void setNumero(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public void setFechas(LocalDate nuevaFecha){
        this.fechaEmicion = nuevaFecha;
        this.fechaVencimiento = nuevaFecha.plusYears(10);
    }

    @Override
    public Documento clone() {
        try {
            return (Documento) super.clone();   // Copia superficial de Documento
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
