package Gestio_datos_dinamicos;

import Analisis_y_gestion_info.*;
import Mapas_y_asociacion_de_datos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class InterfazUsuario extends JFrame {
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private JButton botonAgregar;
    private JButton botonModificar;
    private JButton botonEliminar;
    private JButton botonOrdenar;
    private JButton botonBuscar;
    private JButton botonFiltrar;
    private List<String> listaDatos;

    // Crear una instancia del modelo multidimensional ordenado
    private ModeloMultidimensionalOrdenado modeloOrdenado = new ModeloMultidimensionalOrdenado();

    // Crear una instancia del modelo multidimensional con transacciones
    private ModeloMultidimensionalConTransacciones modeloConTransacciones = new ModeloMultidimensionalConTransacciones();

    public InterfazUsuario() {
        // Configurar el layout
        setLayout(new FlowLayout());

        // Inicializar los componentes
        campoTexto = new JTextField(20);
        areaTexto = new JTextArea(5, 20);
        botonAgregar = new JButton("Agregar");
        botonModificar = new JButton("Modificar");
        botonEliminar = new JButton("Eliminar");
        botonOrdenar = new JButton("Ordenar");
        botonBuscar = new JButton("Buscar");
        botonFiltrar = new JButton("Filtrar");
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

        botonOrdenar.addActionListener(e -> {
            // Agregar pares de enteros al modelo ordenado
            modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(1, 2));
            modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(3, 4));
            modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(5, 6));

            // Imprimir las listas del modelo ordenado
            modeloOrdenado.imprimirListas();
        });

        botonBuscar.addActionListener(e -> {
            // Agregar transacciones al modelo
            modeloConTransacciones.agregarTransaccion(new Transaccion(1, "Producto 1", 10, 100.0));
            modeloConTransacciones.agregarTransaccion(new Transaccion(2, "Producto 2", 20, 200.0));
            modeloConTransacciones.agregarTransaccion(new Transaccion(3, "Producto 3", 30, 300.0));

            // Filtrar transacciones por cantidad
            TreeSet<Transaccion> transaccionesFiltradas = modeloConTransacciones.filtrarTransaccionesPorCantidad(15);

            // Imprimir las transacciones filtradas
            for (Transaccion transaccion : transaccionesFiltradas) {
                areaTexto.append(transaccion.toString() + "\n");
            }
        });

        botonFiltrar.addActionListener(e -> {
            // Filtrar transacciones por precio
            double precio = Double.parseDouble(campoTexto.getText());
            TreeSet<Transaccion> transaccionesFiltradas = modeloConTransacciones.filtrarTransaccionesPorPrecio(precio);

            // Imprimir las transacciones filtradas
            for (Transaccion transaccion : transaccionesFiltradas) {
                areaTexto.append(transaccion.toString() + "\n");
            }
        });

        // Agregar los componentes al frame
        add(campoTexto);
        add(botonAgregar);
        add(botonModificar);
        add(botonEliminar);
        add(botonOrdenar);
        add(botonBuscar);
        add(botonFiltrar);
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
}