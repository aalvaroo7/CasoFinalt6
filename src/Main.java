import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de pares de enteros
        List<Pareja<Integer, Integer>> listaEnteros = new ArrayList<>();
        listaEnteros.add(new Pareja<>(1, 2));
        listaEnteros.add(new Pareja<>(3, 4));
        listaEnteros.add(new Pareja<>(5, 6));

        // Crear una lista de pares de datos reales
        List<Pareja<Double, Double>> listaReales = new ArrayList<>();
        listaReales.add(new Pareja<>(1.1, 2.2));
        listaReales.add(new Pareja<>(3.3, 4.4));
        listaReales.add(new Pareja<>(5.5, 6.6));

        // Imprimir las listas
        System.out.println("Lista de pares de enteros: " + listaEnteros);
        System.out.println("Lista de pares de datos reales: " + listaReales);
    }
}