package analisis_y_organizacion_informacion;

import analisis_y_organizacion_informacion.Transaccion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaTransacciones {
    private List<Transaccion> transacciones;

    public ListaTransacciones() {
        this.transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }

    public void eliminarTransaccion(int indice) {
        this.transacciones.remove(indice);
    }

    public Transaccion getTransaccion(int indice) {
        return this.transacciones.get(indice);
    }

    public List<Transaccion> getTransacciones() {
        return this.transacciones;
    }

    public int size() {
        return this.transacciones.size();
    }

    public void ordenarPorMonto() {
        Collections.sort(this.transacciones, Comparator.comparingDouble(Transaccion::getMonto));
    }

    public void ordenarPorFecha() {
        Collections.sort(this.transacciones, Comparator.comparing(Transaccion::getFecha));
    }

    public List<Transaccion> filtrarPorCliente(String cliente) {
        List<Transaccion> filtradas = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getCliente().equalsIgnoreCase(cliente)) {
                filtradas.add(transaccion);
            }
        }
        return filtradas;
    }

    public List<Transaccion> filtrarPorRangoDeFechas(String fechaInicial, String fechaFinal) {
        List<Transaccion> filtradas = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getFecha().compareTo(fechaInicial) >= 0 && transaccion.getFecha().compareTo(fechaFinal) <= 0) {
                filtradas.add(transaccion);
            }
        }
        return filtradas;
    }

    public List<Transaccion> filtrarPorMontoMinimo(double montoMinimo) {
        List<Transaccion> filtradas = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getMonto() >= montoMinimo) {
                filtradas.add(transaccion);
            }
        }
        return filtradas;
    }

    public List<Transaccion> filtrarPorMontoMaximo(double montoMaximo) {
        List<Transaccion> filtradas = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getMonto() <= montoMaximo) {
                filtradas.add(transaccion);
            }
        }
        return filtradas;
    }
    public List<Transaccion> recuperarInformacion(String criterio) {
        List<Transaccion> result = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getCliente().contains(criterio)) {
                result.add(transaccion);
            }
        }
        return result;
    }
}