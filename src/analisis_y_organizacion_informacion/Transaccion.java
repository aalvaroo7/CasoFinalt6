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

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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