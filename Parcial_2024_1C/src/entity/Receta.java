package entity;

public class Receta {
    private static int contador = 0;
    private final int idReceta;
    private boolean procesado = false;
    private final Estudio[] estudios;
    private final Paciente paciente;
    private final Profesional profesional;

    public Receta(Profesional profesional, Paciente paciente, Estudio[] estudios){
        this.profesional = profesional;
        this.paciente = paciente;
        this.estudios = estudios;
        contador++;
        this.idReceta = contador;
        for(Estudio estudio : estudios){
            paciente.agendarEstudio();
        }
    }

    public void procesar(){
        procesado = true;
        for(Estudio estudio : estudios){
            estudio.realizar(paciente, profesional);
            paciente.realizarEstudio();
        }
    }

    public int getIdReceta() {
        return idReceta;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public Estudio[] getEstudios() {
        return estudios;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    @Override
    public String toString() {
        String estado;
        if(isProcesado()){
            estado = "PROCESADA";
        }else{
            estado = "CARGADA";
        }
        String salida = "Receta " + idReceta +
                "\n - Profesional: " + profesional +
                "\n - Paciente: " + paciente +
                "\n - Estado: " + estado +
                "\n - Estudios:";
        return salida;
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        }

        if(otro == null || !(otro instanceof Receta)){
            return false;
        }
        Receta aux = (Receta) otro;
        return this.idReceta == aux.idReceta;
    }
}
