package Analisis_y_gestion_info;

import Gestio_datos_dinamicos.Modelo_multidimensional;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class ModeloMultidimensionalConTransacciones extends Modelo_multidimensional {
    private TreeSet<Transaccion> transacciones;

    public ModeloMultidimensionalConTransacciones() {
        super();
        transacciones = new TreeSet<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public TreeSet<Transaccion> filtrarTransaccionesPorProducto(String producto) {
        TreeSet<Transaccion> resultado = new TreeSet<>();
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getProducto().equals(producto)) {
                resultado.add(transaccion);
            }
        }
        return resultado;
    }

    public TreeSet<Transaccion> filtrarTransaccionesPorCantidad(int cantidad) {
        return transacciones.stream()
                .filter(transaccion -> transaccion.getCantidad() >= cantidad)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // You can add more filtering methods as needed...
}