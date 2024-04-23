package Gestion_de_datos_dinamicos;

import Gestion_de_datos_dinamicos.Pareja;
import analisis_y_organizacion_informacion.Buscador;
import analisis_y_organizacion_informacion.Ordenador;

import java.util.ArrayList;
import java.util.List;

public class ListaDatos {
    private List<Pareja> datos;

    public ListaDatos() {
        this.datos = new ArrayList<>();
    }

    public void agregarPareja(Pareja pareja) {
        this.datos.add(pareja);
    }

    public void eliminarPareja(int indice) {
        this.datos.remove(indice);
    }

    public Pareja getPareja(int indice) {
        return this.datos.get(indice);
    }

    public List<Pareja> getDatos() {
        return this.datos;
    }

    public int size() {
        return this.datos.size();
    }

    public void ordenarPorPrimerNumero() {
        Ordenador.ordenarPorPrimerNumero(this.datos);
    }

    public void ordenarPorSegundoNumero() {
        Ordenador.ordenarPorSegundoNumero(this.datos);
    }

    public int buscarPareja(int primerNumero, int segundoNumero) {
        return Buscador.buscarPareja(this.datos, primerNumero, segundoNumero);
    }

}