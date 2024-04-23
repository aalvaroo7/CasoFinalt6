package Gestion_de_datos_dinamicos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private ListaDatos listaDatos;
    private JTable tablaDatos;

    public VentanaPrincipal() {
        super("Ventana Principal");
        setLayout(new BorderLayout());

        // Crear la lista de datos
        listaDatos = new ListaDatos();

        // Crear la tabla de datos
        tablaDatos = new JTable(new ListaDatosTableModel(listaDatos));
        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        add(scrollPane, BorderLayout.CENTER);

        // Crear los botones
        JButton botonAgregar = new JButton("Agregar");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonModificar = new JButton("Modificar");

        // Agregar acciones a los botones
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para agregar datos
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para eliminar datos
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para modificar datos
            }
        });

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonModificar);

        // Agregar el panel de botones a la ventana
        add(panelBotones, BorderLayout.SOUTH);

        // Configurar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
