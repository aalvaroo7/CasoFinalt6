package Gestio_datos_dinamicos;

import java.util.List;
import java.util.ArrayList;

public class ListaDatos {
    private List<Pareja> datos;

    public ListaDatos() {
        this.datos = new ArrayList<>();
    }

    // Método para agregar un dato
    public void agregarDato(Pareja dato) {
        this.datos.add(dato);
    }

    // Método para eliminar un dato
    public void eliminarDato(Pareja dato) {
        this.datos.remove(dato);
    }

    // Método para obtener un dato en una posición específica
    public Pareja obtenerDato(int indice) {
        return this.datos.get(indice);
    }

    // Método para actualizar un dato en una posición específica
    public void actualizarDato(int indice, Pareja nuevoDato) {
        this.datos.set(indice, nuevoDato);
    }

    // Método para obtener el tamaño de la lista de datos
    public int obtenerTamanio() {
        return this.datos.size();
    }

    // Método para verificar si la lista de datos está vacía
    public boolean estaVacia() {
        return this.datos.isEmpty();
    }
}