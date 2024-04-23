package Gestion_de_datos_dinamicos;

import java.util.ArrayList;
import java.util.List;

public class ListaDatos {
    private List<Pareja> datos;

    public ListaDatos() {
        this.datos = new ArrayList<>();
    }

    public void agregarPareja(Pareja pareja) {
        datos.add(pareja);
    }

    public void eliminarPareja(int indice) {
        datos.remove(indice);
    }

    public void modificarPareja(int indice, Pareja nuevaPareja) {
        datos.set(indice, nuevaPareja);
    }

    public List<Pareja> getDatos() {
        return datos;
    }
}