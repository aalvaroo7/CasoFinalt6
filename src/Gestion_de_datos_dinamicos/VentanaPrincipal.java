package Gestion_de_datos_dinamicos;

import analisis_y_organizacion_informacion.ListaTransacciones;
import analisis_y_organizacion_informacion.Transaccion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private ListaTransacciones listaTransacciones;
    private JTable tablaTransacciones;
    private JTextField campoId;
    private JTextField campoMonto;
    private JTextField campoFecha;
    private JTextField campoCliente;

    public VentanaPrincipal() {
        super("Lista de Transacciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear la lista de transacciones
        listaTransacciones = new ListaTransacciones();

        // Crear el panel de entrada de datos
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(4, 2));
        panelEntrada.add(new JLabel("ID:"));
        campoId = new JTextField(5);
        panelEntrada.add(campoId);
        panelEntrada.add(new JLabel("Monto:"));
        campoMonto = new JTextField(5);
        panelEntrada.add(campoMonto);
        panelEntrada.add(new JLabel("Fecha:"));
        campoFecha = new JTextField(10);
        panelEntrada.add(campoFecha);
        panelEntrada.add(new JLabel("Cliente:"));
        campoCliente = new JTextField(20);
        panelEntrada.add(campoCliente);

        // Crear el botón de agregar transacción
        JButton botonAgregar = new JButton("Agregar transacción");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    double monto = Double.parseDouble(campoMonto.getText());
                    String fecha = campoFecha.getText();
                    String cliente = campoCliente.getText();
                    Transaccion nuevaTransaccion = new Transaccion(id, monto, fecha, cliente);
                    listaTransacciones.agregarTransaccion(nuevaTransaccion);
                    tablaTransacciones.updateUI();
                    campoId.setText("");
                    campoMonto.setText("");
                    campoFecha.setText("");
                    campoCliente.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, ingrese valores numéricos válidos para el ID y el monto.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonAgregar);

        // Crear el botón de modificar transacción
        JButton botonModificar = new JButton("Modificar transacción");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = tablaTransacciones.getSelectedRow();
                if (indiceSeleccionado >= 0) {
                    try {
                        int id = Integer.parseInt(campoId.getText());
                        double monto = Double.parseDouble(campoMonto.getText());
                        String fecha = campoFecha.getText();
                        String cliente = campoCliente.getText();
                        Transaccion transaccionSeleccionada = listaTransacciones.getTransaccion(indiceSeleccionado);
                        transaccionSeleccionada.setId(id);
                        transaccionSeleccionada.setMonto(monto);
                        transaccionSeleccionada.setFecha(fecha);
                        transaccionSeleccionada.setCliente(cliente);
                        tablaTransacciones.updateUI();
                        campoId.setText("");
                        campoMonto.setText("");
                        campoFecha.setText("");
                        campoCliente.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, ingrese valores numéricos válidos para el ID y el monto.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, seleccione una transacción.", "Seleccione una transacción", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonModificar);

        // Crear el botón de eliminar transacción
        JButton botonEliminar = new JButton("Eliminar transacción");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = tablaTransacciones.getSelectedRow();
                if (indiceSeleccionado >= 0) {
                    listaTransacciones.eliminarTransaccion(indiceSeleccionado);
                    tablaTransacciones.updateUI();
                } else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, seleccione una transacción.", "Seleccione una transacción", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonEliminar);

        // Crear el botón de ordenar por monto
        JButton botonOrdenarPorMonto = new JButton("Ordenar por monto");
        botonOrdenarPorMonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTransacciones.ordenarPorMonto();
                tablaTransacciones.updateUI();
            }
        });
        panelEntrada.add(botonOrdenarPorMonto);

        // Crear el botón de ordenar por fecha
        JButton botonOrdenarPorFecha = new JButton("Ordenar por fecha");
        botonOrdenarPorFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTransacciones.ordenarPorFecha();
                tablaTransacciones.updateUI();
            }
        });
        panelEntrada.add(botonOrdenarPorFecha);

        // Crear el botón de filtrar por cliente
        JButton botonFiltrarPorCliente = new JButton("Filtrar por cliente");
        botonFiltrarPorCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el nombre del cliente:", "Filtrar por cliente", JOptionPane.QUESTION_MESSAGE);
                if (cliente != null && !cliente.isEmpty()) {
                    List<Transaccion> filtradas = listaTransacciones.filtrarPorCliente(cliente);
                    tablaTransacciones.setModel(new TransaccionesTableModel(filtradas));
                }
            }
        });
        panelEntrada.add(botonFiltrarPorCliente);

        // Crear el botón de filtrar por rango de fechas
        JButton botonFiltrarPorRangoDeFechas = new JButton("Filtrar por rango de fechas");
        botonFiltrarPorRangoDeFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaInicial = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese la fecha inicial (yyyy-mm-dd):", "Filtrar por rango de fechas", JOptionPane.QUESTION_MESSAGE);
                String fechaFinal = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese la fecha final (yyyy-mm-dd):", "Filtrar por rango de fechas", JOptionPane.QUESTION_MESSAGE);
                if (fechaInicial != null && !fechaInicial.isEmpty() && fechaFinal != null && !fechaFinal.isEmpty()) {
                    List<Transaccion> filtradas = listaTransacciones.filtrarPorRangoDeFechas(fechaInicial, fechaFinal);
                    tablaTransacciones.setModel(new TransaccionesTableModel(filtradas));
                }
            }
        });
        panelEntrada.add(botonFiltrarPorRangoDeFechas);

        // Crear el botón de filtrar por monto mínimo
        JButton botonFiltrarPorMontoMinimo = new JButton("Filtrar por monto mínimo");
        botonFiltrarPorMontoMinimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoMinimoStr = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el monto mínimo:", "Filtrar por monto mínimo", JOptionPane.QUESTION_MESSAGE);
                if (montoMinimoStr != null && !montoMinimoStr.isEmpty()) {
                    try {
                        double montoMinimo = Double.parseDouble(montoMinimoStr);
                        List<Transaccion> filtradas = listaTransacciones.filtrarPorMontoMinimo(montoMinimo);
                        tablaTransacciones.setModel(new TransaccionesTableModel(filtradas));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, ingrese un valor numérico válido para el monto mínimo.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panelEntrada.add(botonFiltrarPorMontoMinimo);

        // Crear el botón de filtrar por monto máximo
        JButton botonFiltrarPorMontoMaximo = new JButton("Filtrar por monto máximo");
        botonFiltrarPorMontoMaximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoMaximoStr = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el monto máximo:", "Filtrar por monto máximo", JOptionPane.QUESTION_MESSAGE);
                if (montoMaximoStr != null && !montoMaximoStr.isEmpty()) {
                    try {
                        double montoMaximo = Double.parseDouble(montoMaximoStr);
                        List<Transaccion> filtradas = listaTransacciones.filtrarPorMontoMaximo(montoMaximo);
                        tablaTransacciones.setModel(new TransaccionesTableModel(filtradas));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, ingrese un valor numérico válido para el monto máximo.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panelEntrada.add(botonFiltrarPorMontoMaximo);

        // Crear el botón de limpiar filtros
        JButton botonLimpiarFiltros = new JButton("Limpiar filtros");
        botonLimpiarFiltros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaTransacciones.setModel(new TransaccionesTableModel(listaTransacciones.getTransacciones()));
            }
        });
        panelEntrada.add(botonLimpiarFiltros);

        // Crear la tabla de transacciones
        String[] columnas = {"ID", "Monto", "Fecha", "Cliente"};
        tablaTransacciones = new JTable(new TransaccionesTableModel(listaTransacciones.getTransacciones()), columnas);

        // Crear el panel de la tabla
        JScrollPane scrollPane = new JScrollPane(tablaTransacciones);
        JPanel panelTabla = new JPanel();
        panelTabla.add(scrollPane);

        // Agregar los paneles al marco
        getContentPane().add(panelEntrada, BorderLayout.NORTH);
        getContentPane().add(panelTabla, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }
}

