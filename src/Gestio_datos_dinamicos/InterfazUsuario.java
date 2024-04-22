package Gestio_datos_dinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazUsuario extends JFrame {
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private JButton botonAgregar;
    private JButton botonModificar;
    private JButton botonEliminar;
    private List<String> listaDatos;

    public InterfazUsuario() {
        // Configurar el layout
        setLayout(new FlowLayout());

        // Inicializar los componentes
        campoTexto = new JTextField(20);
        areaTexto = new JTextArea(5, 20);
        botonAgregar = new JButton("Agregar");
        botonModificar = new JButton("Modificar");
        botonEliminar = new JButton("Eliminar");
        listaDatos = new ArrayList<>();

        // Agregar un ActionListener a cada botón
        botonAgregar.addActionListener(e -> {
            // Agregar el texto del campo de texto a la lista
            listaDatos.add(campoTexto.getText());

            // Limpiar el campo de texto
            campoTexto.setText("");

            // Actualizar el área de texto
            actualizarAreaTexto();
        });

        botonModificar.addActionListener(e -> {
            // Modificar el último elemento de la lista con el texto del campo de texto
            if (!listaDatos.isEmpty()) {
                listaDatos.set(listaDatos.size() - 1, campoTexto.getText());

                // Limpiar el campo de texto
                campoTexto.setText("");

                // Actualizar el área de texto
                actualizarAreaTexto();
            }
        });

        botonEliminar.addActionListener(e -> {
            // Eliminar el último elemento de la lista
            if (!listaDatos.isEmpty()) {
                listaDatos.remove(listaDatos.size() - 1);

                // Actualizar el área de texto
                actualizarAreaTexto();
            }
        });

        // Agregar los componentes al frame
        add(campoTexto);
        add(botonAgregar);
        add(botonModificar);
        add(botonEliminar);
        add(new JScrollPane(areaTexto));

        // Configurar el frame
        setTitle("Interfaz de Usuario Interactiva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    private void actualizarAreaTexto() {
        // Limpiar el área de texto
        areaTexto.setText("");

        // Agregar cada dato de la lista al área de texto
        for (String dato : listaDatos) {
            areaTexto.append(dato + "\n");
        }
    }
    // En la clase InterfazUsuario
botonEliminar.addActionListener(e -> {
        // Eliminar el último elemento de la lista
        if (!listaDatos.isEmpty()) {
            listaDatos.remove(listaDatos.size() - 1);

            // Actualizar el área de texto
            actualizarAreaTexto();
        }
    });

}