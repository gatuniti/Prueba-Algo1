import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    public static List<String> leerLineas(String nombreArchivo){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            List<String> lineas = new ArrayList<>();
            //Mientras la linea no sea nula, la agrego a la lista
            while ((linea = bufferedReader.readLine()) != null) {
                lineas.add(linea);
            }
            return lineas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[][] parsearLineas(List<String> lineas, String sep){
        int filas = lineas.size();
        String[][] celdas = null;
        for(int i = 0; i < filas; i++){
            String linea = lineas.get(i);
            String[] campos = linea.split(sep);
            //Si celda sigue siendo null (es la primer linea), creo la matriz con los largos del archivo:
            if(celdas == null){
                celdas = new String[filas][campos.length];
            }
            if (campos.length != celdas[0].length) {
                int lineaFalla = i+1;
                //Esto tal vez podría ser una excepción personalizada:
                throw new RuntimeException("A la fila " + lineaFalla + " le faltan datos.");
            }
            //Por cada celda de la linea, la agrego en la coordenada que le corresponde:
            for(int j = 0; j < campos.length; j++){
                celdas[i][j] = campos[j];
            }
        }
        return celdas;
    }
}
