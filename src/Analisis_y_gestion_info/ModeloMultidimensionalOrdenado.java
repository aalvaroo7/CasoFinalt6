package Analisis_y_gestion_info;

import Gestio_datos_dinamicos.Modelo_multidimensional;

import java.util.TreeSet;

public class ModeloMultidimensionalOrdenado extends Modelo_multidimensional {
    private TreeSet<ParejaOrdenada<Integer, Integer>> conjuntoEnteros;
    private TreeSet<ParejaOrdenada<Double, Double>> conjuntoReales;

    public ModeloMultidimensionalOrdenado() {
        conjuntoEnteros = new TreeSet<>();
        conjuntoReales = new TreeSet<>();
    }

    @Override
    public void agregarParejaEnteros(Pareja<Integer, Integer> pareja) {
        conjuntoEnteros.add(new ParejaOrdenada<>(pareja.getFirst(), pareja.getSecond()));
    }

    @Override
    public void agregarParejaReales(Pareja<Double, Double> pareja) {
        conjuntoReales.add(new ParejaOrdenada<>(pareja.getFirst(), pareja.getSecond()));
    }

    @Override
    public void imprimirListas() {
        System.out.println("Conjunto de pares de enteros: " + conjuntoEnteros);
        System.out.println("Conjunto de pares de datos reales: " + conjuntoReales);
    }
}