package Gestion_de_datos_dinamicos;

import Indexacion_y_Visualizacion_datos.IndexadorArchivos;
import analisis_y_organizacion_informacion.ListaTransacciones;
import analisis_y_organizacion_informacion.Transaccion;
import analisis_y_organizacion_informacion.TransaccionesTableModel;
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
    private JButton botonRecuperarInformacion; // Mueve la declaración aquí
    private IndexadorArchivos indexadorArchivos; // Agrega esta línea

    public VentanaPrincipal() {
        super("Lista de Transacciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear la lista de transacciones
        listaTransacciones = new ListaTransacciones();

        // Instancia IndexadorArchivos
        indexadorArchivos = new IndexadorArchivos(); // Agrega esta línea

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

        // Crear el botón de recuperar información basada en claves o criterios definidos por el usuario
        botonRecuperarInformacion = new JButton("Recuperar Información");
        botonRecuperarInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String criterio = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el criterio de búsqueda:", "Recuperar Información", JOptionPane.QUESTION_MESSAGE);
                if (criterio != null && !criterio.isEmpty()) {
                    // Lógica para recuperar información basada en el criterio definido por el usuario
                    List<Transaccion> recuperadas = listaTransacciones.recuperarInformacion(criterio);
                    tablaTransacciones.setModel(new TransaccionesTableModel(recuperadas));
                }
            }
        });
        panelEntrada.add(botonRecuperarInformacion);

        // Crear el botón de indexar archivos
        JButton botonIndexarArchivos = new JButton("Indexar Archivos");
        botonIndexarArchivos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directory = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el directorio a indexar:", "Indexar Archivos", JOptionPane.QUESTION_MESSAGE);
                if (directory != null && !directory.isEmpty()) {
                    indexadorArchivos.index(directory);
                    List<String> fileNames = indexadorArchivos.getFileNames();
                    List<String> filePaths = indexadorArchivos.getFilePaths();

                    // Aquí puedes usar las listas fileNames y filePaths como necesites
                    // Por ejemplo, podrías mostrarlas en un JOptionPane
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Archivos indexados:\n" + fileNames.toString(), "Archivos Indexados", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panelEntrada.add(botonIndexarArchivos);

        // Crear la tabla de transacciones
        String[] columnas = {"ID", "Monto", "Fecha", "Cliente"};
        tablaTransacciones = new JTable(new TransaccionesTableModel(listaTransacciones.getTransacciones()));
        // Crear el panel de la tabla
        JScrollPane scrollPane = new JScrollPane(tablaTransacciones);
        JPanel panelTabla = new JPanel();
        panelTabla.add(scrollPane);

        // Crear el contenedor principal y agregar los componentes
        JPanel contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new BorderLayout());
        contenedorPrincipal.add(panelEntrada, BorderLayout.NORTH);
        contenedorPrincipal.add(panelTabla, BorderLayout.CENTER);

        // Agregar el contenedor principal a la ventana
        getContentPane().add(contenedorPrincipal);

        // Mostrar la ventana
        setVisible(true);
    }

    // Método main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}