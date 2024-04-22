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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Transaccion otraTransaccion) {
        return Integer.compare(this.id, otraTransaccion.id);
    }
}