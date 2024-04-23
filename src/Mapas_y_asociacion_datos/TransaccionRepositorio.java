package Mapas_y_asociacion_datos;

import analisis_y_organizacion_informacion.Transaccion;

import java.util.ArrayList;

// Create a Repository Class
public class TransaccionRepositorio {
    private List<Transaccion> transacciones;

    public TransaccionRepositorio() {
        this.transacciones = new ArrayList<>();
    }

    public void addTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }

    public void updateTransaccion(int index, Transaccion transaccion) {
        this.transacciones.set(index, transaccion);
    }

    public void deleteTransaccion(int index) {
        this.transacciones.remove(index);
    }

    public List<Transaccion> getTransacciones() {
        return this.transacciones;
    }

    public List<Transaccion> filterTransacciones(String criteria) {
        List<Transaccion> filtradas = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getCliente().contains(criteria)) {
                filtradas.add(transaccion);
            }
        }
        return filtradas;
    }
}