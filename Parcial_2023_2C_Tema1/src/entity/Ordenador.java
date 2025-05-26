package entity;

import java.util.Collections;
import java.util.List;

public class Ordenador {
    public static <T extends Comparable<T>> void quickSort(List<T> lista) {
        quickSortRec(lista, 0, lista.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSortRec(List<T> lista, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivot = partition(lista, inicio, fin);
            quickSortRec(lista, inicio, indicePivot - 1);
            quickSortRec(lista, indicePivot + 1, fin);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> lista, int inicio, int fin) {
        T pivot = lista.get(fin);
        int i = inicio;
        int j = fin - 1;

        while (i <= j) {
            while (i <= j && lista.get(i).compareTo(pivot) <= 0) {
                i++;
            }
            while (i <= j && lista.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i < j) {
                Collections.swap(lista, i++, j--);
            }
        }

        Collections.swap(lista, i, fin);
        return i;
    }
}
