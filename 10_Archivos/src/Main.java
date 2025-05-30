import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "10_Archivos/src/IRIS.csv";
        String separador = ",";
        //String[][] matriz = LectorCSV.parsearLineas(LectorCSV.leerLineas(nombreArchivo), separador);
        //System.out.println(matriz[150].length);
        List<String> lineas = new ArrayList<>();
        lineas.add("hola,que,hace");
        lineas.add("pepe,pepa,pepi");
        lineas.add("pupu,pipu");
        String[][] matriz = LectorCSV.parsearLineas(lineas, separador);
    }
}