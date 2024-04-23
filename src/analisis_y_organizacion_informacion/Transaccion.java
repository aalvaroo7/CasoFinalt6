package analisis_y_organizacion_informacion;

public class Transaccion {
    private int id;
    private double monto;
    private String fecha;
    private String cliente;

    public Transaccion(int id, double monto, String fecha, String cliente) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}