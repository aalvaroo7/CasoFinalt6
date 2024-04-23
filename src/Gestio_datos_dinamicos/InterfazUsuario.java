package Gestio_datos_dinamicos;

import Analisis_y_gestion_info.*;
import Mapas_y_asociacion_de_datos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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
    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    // Crear una instancia del modelo multidimensional ordenado
    private ModeloMultidimensionalOrdenado modeloOrdenado = new ModeloMultidimensionalOrdenado();

    // Crear una instancia del modelo multidimensional con transacciones
    private ModeloMultidimensionalConTransacciones modeloConTransacciones = new ModeloMultidimensionalConTransacciones();

    // Crear una instancia del indexador recursivo
    private IndexadorRecursivo indexador = new IndexadorRecursivo();

    // Crear una instancia de la gestión de relaciones
    private GestionRelaciones relaciones = new GestionRelaciones();

    // Crear una instancia de la recuperación eficiente
    private RecuperacionEficiente<Integer, String> recuperacionEficiente = new RecuperacionEficiente<>();

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
        listaEnteros = new ArrayList<>();
        listaCadenas = new ArrayList<>();

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
            String texto = campoTexto.getText();
            try {
                // Intentar convertir el texto a un entero
                int numero = Integer.parseInt(texto);

                // Si la conversión es exitosa, agregar el número a la lista de enteros
                listaEnteros.add(numero);

                // Ordenar la lista de enteros de mayor a menor
                listaEnteros.sort(Collections.reverseOrder());

                // Limpiar el área de texto y mostrar la lista de enteros ordenada
                areaTexto.setText("");
                for (int i : listaEnteros) {
                    areaTexto.append(i + "\n");
                }
            } catch (NumberFormatException ex) {
                // Si la conversión falla, agregar el texto a la lista de cadenas
                listaCadenas.add(texto);

                // Ordenar la lista de cadenas en orden alfabético
                Collections.sort(listaCadenas);

                // Limpiar el área de texto y mostrar la lista de cadenas ordenada
                areaTexto.setText("");
                for (String s : listaCadenas) {
                    areaTexto.append(s + "\n");
                }
            }

            // Limpiar el campo de texto
            campoTexto.setText("");
        });

        botonBuscar.addActionListener(e -> {
            // Buscar el archivo con el nombre ingresado
            String rutaArchivo = indexador.buscarArchivo(campoTexto.getText());

            // Mostrar la ruta del archivo en el área de texto
            areaTexto.setText(rutaArchivo != null ? rutaArchivo : "Archivo no encontrado");

            // Limpiar el campo de texto
            campoTexto.setText("");
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