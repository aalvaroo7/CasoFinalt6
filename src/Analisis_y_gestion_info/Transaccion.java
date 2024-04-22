package Analisis_y_gestion_info;

public class Transaccion implements Comparable<Transaccion> {
    private int id;
    private String producto;
    private int cantidad;
    private double precio;

    public Transaccion(int id, String producto, int cantidad, double precio) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters...

    @Override
    public int compareTo(Transaccion otraTransaccion) {
        return Integer.compare(this.id, otraTransaccion.id);
    }
}