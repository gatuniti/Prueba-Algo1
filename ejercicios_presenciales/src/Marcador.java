/*
Ejercicio de modelar y crear la clase "Marcador" que corresponde a marcadores
recargables. Clase 1/4/25.
En el ejemplo que se dió en el pizarrón, "color" es de tipo "Color". Lo cambié a
tipo "String" porque por la naturaleza del ejercicio no valía la pena crear
otra clase extra.
Agregué el método "seReparo" para reparar marcadores porque si.
*/

public class Marcador {
    private String color;
    private double carga;
    private boolean daniado;

    public Marcador(String color){
        this.color = color;
        this.carga = 0.0;
        this.daniado = false;
    }

    public boolean estaDisponible(){
        return this.carga>0.9 && !daniado;
    }

    //Versión original del método "recargar", lo cambié por una versión mejor hecha.
    /*
    public void recargar(){
        this.carga = 1.0;
    }
     */

    public void recargar(double carga){
        if(this.carga + carga <= 1.0){
            this.carga +=  carga;
        }else{
            this.carga = 1.0;
        }

    }

    public void seDanio(){
        daniado = true;
    }

    public void seReparo(){
        daniado = false;
    }

    public String toString(){
        return String.format("color: %s, carga: %f, daniado: %s", color, carga, daniado);
    }

    /*
    Los getters y setters me parecen al pedo por la naturaleza del ejercicio. Los
    hice para demostrar que se hacerlos.
     */
    public double getCarga(){
        return carga;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setCarga(double carga){
         this.carga = carga;
    }

    public void setDaniado(boolean daniado){
        this.daniado = daniado;
    }
}
