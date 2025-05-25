//Ejercicio: Caja contenedora
public class Contenedor<T> {
    protected T elementoContenido = null;

    public Contenedor(){}

    public Contenedor(T elementoContenido){
        this.elementoContenido = elementoContenido;
    }

    public void agregarElemento(T elemento){
        if(!this.estaVacia()){
            throw new IllegalStateException("La caja ya tiene un elemento.");
        }
        this.elementoContenido = elemento;
    }

    public void quitarElemento(){
        if(this.estaVacia()){
            throw new IllegalStateException("La caja ya está vacía.");
        }
        this.elementoContenido = null;
    }

    public Boolean estaVacia(){
        return elementoContenido == null;
    }

    public boolean esIgual(Contenedor otro){
        if(this == otro){
            return true;
        }

        if(otro.estaVacia() || this.estaVacia()){
            return false;
        }

        if(otro.elementoContenido.getClass() != this.elementoContenido.getClass()){
            return false;
        }

        return otro.elementoContenido == this.elementoContenido;
    }

    public T getElementoContenido() {
        return elementoContenido;
    }

    @Override
    public String toString(){
        String salida;
        if(this.estaVacia()){
            salida = "La caja está vacía";
        }else{
            salida = "La caja contiene: " + elementoContenido;
        }
        return salida;
    }
}
