package analisis_y_organizacion_informacion;

import analisis_y_organizacion_informacion.Transaccion;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TransaccionesTableModel extends AbstractTableModel {
    private List<Transaccion> transacciones;
    private String[] columnNames = {"ID", "Monto", "Fecha", "Cliente"};

    public TransaccionesTableModel(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public int getRowCount() {
        return transacciones.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaccion transaccion = transacciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return transaccion.getId();
            case 1:
                return transaccion.getMonto();
            case 2:
                return transaccion.getFecha();
            case 3:
                return transaccion.getCliente();
            default:
                return null;
        }
    }
}