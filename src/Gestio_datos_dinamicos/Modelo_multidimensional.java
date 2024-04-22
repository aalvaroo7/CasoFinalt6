package Gestio_datos_dinamicos;

import java.util.ArrayList;
import java.util.List;

public class Modelo_multidimensional {
    private List<Pareja<Integer, Integer>> listaEnteros;
    private List<Pareja<Double, Double>> listaReales;

    public Modelo_multidimensional() {
        listaEnteros = new ArrayList<>();
        listaReales = new ArrayList<>();
    }

    public void agregarParejaEnteros(Pareja<Integer, Integer> pareja) {
        listaEnteros.add(pareja);
    }

    public void agregarParejaReales(Pareja<Double, Double> pareja) {
        listaReales.add(pareja);
    }

    public void imprimirListas() {
        System.out.println("Lista de pares de enteros: " + listaEnteros);
        System.out.println("Lista de pares de datos reales: " + listaReales);
    }
    // En la clase Modelo_multidimensional
    public boolean buscarDato(Pareja<Integer, Integer> dato) {
        return listaEnteros.contains(dato) || listaReales.contains(dato);
    }
}