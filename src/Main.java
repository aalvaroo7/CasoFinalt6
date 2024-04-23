import Gestio_datos_dinamicos.*;
import Analisis_y_gestion_info.*;
import Mapas_y_asociacion_de_datos.*;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la interfaz de usuario
        InterfazUsuario interfazUsuario = new InterfazUsuario();

        // Crear una instancia del modelo multidimensional ordenado
        ModeloMultidimensionalOrdenado modeloOrdenado = new ModeloMultidimensionalOrdenado();

        // Crear una instancia del modelo multidimensional con transacciones
        ModeloMultidimensionalConTransacciones modeloConTransacciones = new ModeloMultidimensionalConTransacciones();

        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar un menú de opciones al usuario
        System.out.println("Seleccione una opción:");
        System.out.println("1. Ordenar y buscar datos");
        System.out.println("2. Salir");

        // Leer la opción seleccionada por el usuario
        int opcion = scanner.nextInt();

        // Ejecutar la opción seleccionada
        switch (opcion) {
            case 1:
                // Agregar pares de enteros al modelo ordenado
                modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(1, 2));
                modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(3, 4));
                modeloOrdenado.agregarParejaEnteros(new ParejaOrdenada<>(5, 6));

                // Imprimir las listas del modelo ordenado
                modeloOrdenado.imprimirListas();

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
                break;
            case 2:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                break;
        }
    }
}