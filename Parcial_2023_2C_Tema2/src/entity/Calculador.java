package entity;

import java.time.LocalDate;
import java.util.*;

public class Calculador {
    public static void calcularResultadoFecha(LocalDate fecha, List<Donacion> donaciones, Map<String, Number> resultados){
        int cantCobradas = 0;
        int cantRechazadas = 0;
        int cantPendientes = 0;
        List<Number> montosCobrados = new ArrayList<>();
        for(Donacion donacion : donaciones){
            if(donacion.getFecha().isBefore(fecha) || donacion.getFecha().isEqual(fecha)){
                if(donacion.getEstado() == EstadoDonacion.COBRADA){
                    cantCobradas++;
                    montosCobrados.add(donacion.getMonto());
                }else if(donacion.getEstado() == EstadoDonacion.RECHAZADA){
                    cantRechazadas++;
                }else{
                    cantPendientes++;
                }
            }
        }

        if(cantCobradas > 0){
            calcularInfoCobrada(montosCobrados, resultados);
        }
        resultados.put("cobradas", cantCobradas);
        resultados.put("rechazadas", cantRechazadas);
        resultados.put("pendientes", cantPendientes);
    }

    public static void calcularInfoCobrada(List<Number> montosCobrados, Map<String, Number> resultados){
        double maximo = 0;
        double minimo = montosCobrados.get(0).doubleValue();
        double total = 0;
        for(Number monto : montosCobrados){
            total += monto.doubleValue();
            if(monto.doubleValue() > maximo){
                maximo = monto.doubleValue();
            }
            if(monto.doubleValue() < minimo){
                minimo = monto.doubleValue();
            }
        }
        resultados.put("total", total);
        resultados.put("maximo", maximo);
        resultados.put("minimo", minimo);
    }
}
