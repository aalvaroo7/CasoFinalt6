package Gestion_de_datos_dinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class VentanaPrincipal extends JFrame {
    private ListaDatos listaDatos;
    private JTable tablaDatos;
    private JTextField campoPrimerNumero;
    private JTextField campoSegundoNumero;

    public VentanaPrincipal() {
        super("Lista de Datos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        // Crear la lista de datos
        listaDatos = new ListaDatos();

        // Crear el panel de entrada de datos
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(2, 2));
        panelEntrada.add(new JLabel("Primer número:"));
        campoPrimerNumero = new JTextField(5);
        panelEntrada.add(campoPrimerNumero);
        panelEntrada.add(new JLabel("Segundo número:"));
        campoSegundoNumero = new JTextField(5);
        panelEntrada.add(campoSegundoNumero);

        // Crear el botón de agregar datos
        JButton botonAgregar = new JButton("Agregar datos");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int primerNumero = Integer.parseInt(campoPrimerNumero.getText());
                    int segundoNumero = Integer.parseInt(campoSegundoNumero.getText());
                    Pareja nuevaPareja = new Pareja(primerNumero, segundoNumero);
                    listaDatos.agregarPareja(nuevaPareja);
                    tablaDatos.updateUI();
                    campoPrimerNumero.setText("");
                    campoSegundoNumero.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Por favor, ingrese números válidos.",
                            "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonAgregar);

        // Crear el botón de modificar datos
        JButton botonModificar = new JButton("Modificar datos");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = tablaDatos.getSelectedRow();
                if (indiceSeleccionado >= 0) {
                    try {
                        int primerNumero = Integer.parseInt(campoPrimerNumero.getText());
                        int segundoNumero = Integer.parseInt(campoSegundoNumero.getText());
                        Pareja parejaSeleccionada = listaDatos.getPareja(indiceSeleccionado);
                        parejaSeleccionada.setPrimerNumero(primerNumero);
                        parejaSeleccionada.setSegundoNumero(segundoNumero);
                        tablaDatos.updateUI();
                        campoPrimerNumero.setText("");
                        campoSegundoNumero.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,
                                "Por favor, ingrese números válidos.",
                                "Error de entrada",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Por favor, seleccione una pareja de datos.",
                            "Seleccione una pareja",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonModificar);

        // Crear el botón de eliminar datos
        JButton botonEliminar = new JButton("Eliminar datos");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = tablaDatos.getSelectedRow();
                if (indiceSeleccionado >= 0) {
                    listaDatos.eliminarPareja(indiceSeleccionado);
                    tablaDatos.updateUI();
                } else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Por favor, seleccione una pareja de datos.",
                            "Seleccione una pareja",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonEliminar);

        // Crear el botón de ordenar por primer número
        JButton botonOrdenarPorPrimerNumero = new JButton("Ordenar por primer número");
        botonOrdenarPorPrimerNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDatos.ordenarPorPrimerNumero();
                tablaDatos.updateUI();
            }
        });
        panelEntrada.add(botonOrdenarPorPrimerNumero);

        // Crear el botón de ordenar por segundo número
        JButton botonOrdenarPorSegundoNumero = new JButton("Ordenar por segundo número");
        botonOrdenarPorSegundoNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDatos.ordenarPorSegundoNumero();
                tablaDatos.updateUI();
            }
        });
        panelEntrada.add(botonOrdenarPorSegundoNumero);

        // Crear el botón de buscar pareja
        JButton botonBuscarPareja = new JButton("Buscar pareja");
        botonBuscarPareja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int primerNumero = Integer.parseInt(campoPrimerNumero.getText());
                    int segundoNumero = Integer.parseInt(campoSegundoNumero.getText());
                    int indice = listaDatos.buscarPareja(primerNumero, segundoNumero);
                    if (indice >= 0) {
                        tablaDatos.setRowSelectionInterval(indice, indice);
                    } else {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,
                                "No se encontró la pareja de datos.",
                                "Búsqueda fallida",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Por favor, ingrese números válidos.",
                            "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonBuscarPareja);

        // Crear el modelo de datos de la tabla
        ListaDatosTableModel modeloTabla = new ListaDatosTableModel(listaDatos);

        // Crear la tabla
        tablaDatos = new JTable(modeloTabla);

        // Crear el panel de la tabla
        JScrollPane panelTabla = new JScrollPane(tablaDatos);

        // Agregar los paneles al marco
        getContentPane().add(panelEntrada, BorderLayout.NORTH);
        getContentPane().add(panelTabla, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}