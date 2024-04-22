import Gestio_datos_dinamicos.*;
import Analisis_y_gestion_info.*;
import Mapas_y_asociacion_de_datos.*;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la interfaz de usuario
        InterfazUsuario interfazUsuario = new InterfazUsuario();

        // Crear una instancia del modelo multidimensional
        Modelo_multidimensional modelo = new Modelo_multidimensional();

        // Agregar pares de enteros al modelo
        modelo.agregarParejaEnteros(new Pareja<>(1, 2));
        modelo.agregarParejaEnteros(new Pareja<>(3, 4));
        modelo.agregarParejaEnteros(new Pareja<>(5, 6));

        // Agregar pares de datos reales al modelo
        modelo.agregarParejaReales(new Pareja<>(1.1, 2.2));
        modelo.agregarParejaReales(new Pareja<>(3.3, 4.4));
        modelo.agregarParejaReales(new Pareja<>(5.5, 6.6));

        // Imprimir las listas del modelo
        modelo.imprimirListas();

        // Crear una instancia del modelo multidimensional ordenado
        ModeloMultidimensionalOrdenado modeloOrdenado = new ModeloMultidimensionalOrdenado();

        // Agregar pares de enteros al modelo ordenado
        modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(1, 2));
        modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(3, 4));
        modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(5, 6));

        // Imprimir las listas del modelo ordenado
        modeloOrdenado.imprimirListas();

        // Crear una instancia del modelo multidimensional con transacciones
        ModeloMultidimensionalConTransacciones modeloConTransacciones = new ModeloMultidimensionalConTransacciones();

        // Agregar transacciones al modelo
        modeloConTransacciones.agregarTransaccion(new Transaccion(1, "Producto 1", 10, 100.0));
        modeloConTransacciones.agregarTransaccion(new Transaccion(2, "Producto 2", 20, 200.0));
        modeloConTransacciones.agregarTransaccion(new Transaccion(3, "Producto 3", 30, 300.0));

        // Filtrar transacciones por cantidad
        TreeSet<Transaccion> transaccionesFiltradas = modeloConTransacciones.filtrarTransaccionesPorCantidad(15);

        // Imprimir las transacciones filtradas
        for (Transaccion transaccion : transaccionesFiltradas) {
            System.out.println(transaccion);
        }

        // Crear una instancia del indexador recursivo
        IndexadorRecursivo indexador = new IndexadorRecursivo();

        // Indexar un directorio
        indexador.indexarDirectorio("/ruta/del/directorio");

        // Buscar un archivo en el índice
        String rutaArchivo = indexador.buscarArchivo("nombreDelArchivo.txt");
        System.out.println("Ruta del archivo: " + rutaArchivo);

        // Crear una instancia de la clase de recuperación eficiente
        RecuperacionEficiente<Integer, String> recuperacion = new RecuperacionEficiente<>();

        // Agregar elementos al mapa
        recuperacion.agregarElemento(1, "Uno");
        recuperacion.agregarElemento(2, "Dos");
        recuperacion.agregarElemento(3, "Tres");

        // Recuperar un elemento del mapa
        String valor = recuperacion.recuperarElemento(2);
        System.out.println("Valor recuperado: " + valor);
    }
}