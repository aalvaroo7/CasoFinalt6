package Gestion_de_datos_dinamicos;

import Gestion_de_datos_dinamicos.ListaDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Por favor, ingrese números válidos.",
                            "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonAgregar);

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
}