package Analisis_y_gestion_info;

import Gestio_datos_dinamicos.Modelo_multidimensional;
import Gestio_datos_dinamicos.Pareja;

import java.util.TreeSet;

public class ModeloMultidimensionalOrdenado extends Modelo_multidimensional {
    private TreeSet<ParejaOrdenada<Integer, Integer>> conjuntoEnteros;
    private TreeSet<ParejaOrdenada<Double, Double>> conjuntoReales;

    public ModeloMultidimensionalOrdenado() {
        conjuntoEnteros = new TreeSet<>();
        conjuntoReales = new TreeSet<>();
    }

    public void agregarParejaEnteros(ParejaOrdenada<Integer, Integer> pareja) {
        conjuntoEnteros.add(pareja);
    }

    public void agregarParejaReales(ParejaOrdenada<Double, Double> pareja) {
        conjuntoReales.add(pareja);
    }

    @Override
    public void imprimirListas() {
        System.out.println("Conjunto de pares de enteros: " + conjuntoEnteros);
        System.out.println("Conjunto de pares de datos reales: " + conjuntoReales);
    }
}