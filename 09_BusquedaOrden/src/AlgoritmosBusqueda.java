import java.util.List;

public class AlgoritmosBusqueda {
    //Ejercicio: Búsqueda lineal genérica
    public static <T> int busquedaLinealGenerica(T[] arreglo, T elemento){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] != null && arreglo[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    //Ejercicio: Búsqueda binaria genérica
    //Mucho más eficiente, también se puede hacer con recursividad pero... xd
    public static <T extends Comparable<T>> int busquedaBinariaGenerica(List<T> lista, T elemento) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            T valorMedio = lista.get(medio);
            int comparacion = elemento.compareTo(valorMedio);

            if(comparacion == 0) {
                return medio;
            }else if(comparacion > 0) {
                inicio = medio + 1;
            }else{
                fin = medio - 1;
            }
        }

        return -1;
    }
}
