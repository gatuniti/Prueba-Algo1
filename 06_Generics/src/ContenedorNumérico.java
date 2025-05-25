//Ejercicio: Caja contenedora numérica
public class ContenedorNumérico<T extends Number> extends Contenedor{
    public ContenedorNumérico(T contenido){
        super(contenido);
    }

    public void agregarElemento(T elemento){
        if(!this.estaVacia()){
            throw new IllegalStateException("La caja de números ya tiene un elemento.");
        }
        this.elementoContenido = elemento;
    }

    public void quitarElemento(){
        if(this.estaVacia()){
            throw new IllegalStateException("La caja de números ya está vacía.");
        }
        this.elementoContenido = null;
    }

    @Override
    public String toString(){
        String salida;
        if(this.estaVacia()){
            salida = "La caja de números está vacía";
        }else{
            salida = "La caja de números contiene: " + elementoContenido;
        }
        return salida;
    }
}
