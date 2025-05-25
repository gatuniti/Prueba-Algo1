//Ejercicio: Wrapper de ordenamiento
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgoritmosOrden {
    public enum Orden {
        ASCENDENTE,
        DESCENDENTE
    }

    public enum Algoritmo {
        BUBBLESORT,
        SELECTIONSORT,
        MERGESORT,
        QUICKSORT,
    }

    public static <T extends Comparable<T>> void ordenar(List<T> lista) {
        ordenar(lista, Orden.ASCENDENTE, Algoritmo.MERGESORT);
    }
    public static <T extends Comparable<T>> void ordenar(List<T> lista, Orden orden) {
        ordenar(lista, orden, Algoritmo.MERGESORT);
    }
    public static <T extends Comparable<T>> void ordenar(List<T> lista, Algoritmo algoritmo) {
        ordenar(lista, Orden.ASCENDENTE, algoritmo);
    }
    public static <T extends Comparable<T>> void ordenar(List<T> lista, Orden orden, Algoritmo algoritmo) {
        Comparator<T> comparador = orden == Orden.ASCENDENTE ?
                Comparator.naturalOrder() :
                Comparator.reverseOrder();

        switch (algoritmo) {
            case BUBBLESORT:
                bubbleSort(lista, comparador);
                break;
            case SELECTIONSORT:
                selectionSort(lista, comparador);
                break;
            case MERGESORT:
                mergeSort(lista, comparador);
                break;
            case QUICKSORT:
                quickSort(lista, comparador);
                break;
        }
    }

    //Simple pero MUY ineficiente
    private static <T> void bubbleSort(List<T> lista, Comparator<T> comparator) {
        int n = lista.size();
        boolean huboCambio;
        do {
            huboCambio = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(lista.get(i - 1), lista.get(i)) > 0) {
                    Collections.swap(lista, i - 1, i);
                    huboCambio = true;
                }
            }
            n--;
        } while (huboCambio);
    }

    //Mejor que el bubble pero su peor caso es igual de ineficiente que ese
    private static <T> void selectionSort(List<T> lista, Comparator<T> comparator) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int idxMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(lista.get(j), lista.get(idxMinimo)) < 0) {
                    idxMinimo = j;
                }
            }
            if (i != idxMinimo) {
                Collections.swap(lista, i, idxMinimo);
            }
        }
    }

    //Más eficiente que los dos anteriores
    private static <T> void mergeSort(List<T> lista, Comparator<T> comparator) {
        if (lista.size() <= 1) return;

        int medio = lista.size() / 2;
        List<T> izquierda = new ArrayList<>(lista.subList(0, medio));
        List<T> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        mergeSort(izquierda, comparator);
        mergeSort(derecha, comparator);

        lista.clear();
        int i = 0, j = 0;
        while (i < izquierda.size() && j < derecha.size()) {
            if (comparator.compare(izquierda.get(i), derecha.get(j)) <= 0) {
                lista.add(izquierda.get(i++));
            } else {
                lista.add(derecha.get(j++));
            }
        }
        while (i < izquierda.size()) lista.add(izquierda.get(i++));
        while (j < derecha.size()) lista.add(derecha.get(j++));
    }

    //El más eficiente en tiempo y recursos
    private static <T> void quickSort(List<T> lista, Comparator<T> comparator) {
        quickSortRec(lista, 0, lista.size() - 1, comparator);
    }
    private static <T> void quickSortRec(List<T> lista, int inicio, int fin, Comparator<T> comparator) {
        if (inicio < fin) {
            int pivotIndex = partition(lista, inicio, fin, comparator);
            quickSortRec(lista, inicio, pivotIndex - 1, comparator);
            quickSortRec(lista, pivotIndex + 1, fin, comparator);
        }
    }
    private static <T> int partition(List<T> lista, int inicio, int fin, Comparator<T> comparator) {
        T pivot = lista.get(fin);
        int i = inicio;

        for (int j = inicio; j < fin; j++) {
            if (comparator.compare(lista.get(j), pivot) <= 0) {
                Collections.swap(lista, i++, j);
            }
        }
        Collections.swap(lista, i, fin);
        return i;
    }
}
