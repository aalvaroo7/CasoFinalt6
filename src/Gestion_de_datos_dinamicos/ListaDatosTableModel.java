package Gestion_de_datos_dinamicos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

import Gestion_de_datos_dinamicos.ListaDatos;
public class ListaDatosTableModel extends AbstractTableModel {
    private List<Pareja> datos;

    public ListaDatosTableModel(ListaDatos listaDatos) {
        this.datos = listaDatos.getDatos();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Primer número";
            case 1:
                return "Segundo número";
            default:
                throw new IllegalArgumentException("Columna no válida");
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Pareja pareja = datos.get(row);

        switch (column) {
            case 0:
                return pareja.getPrimerNumero();
            case 1:
                return pareja.getSegundoNumero();
            default:
                throw new IllegalArgumentException("Columna no válida");
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Pareja pareja = datos.get(row);

        switch (column) {
            case 0:
                pareja.setPrimerNumero((int) value);
                break;
            case 1:
                pareja.setSegundoNumero((int) value);
                break;
            default:
                throw new IllegalArgumentException("Columna no válida");
        }

        fireTableCellUpdated(row, column);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return int.class;
    }
}