package Mapas_y_asociacion_de_datos;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

    public class GestionRelaciones {
        private Map<Integer, String> relaciones;

        public GestionRelaciones() {
            relaciones = new HashMap<>();
        }

        public void agregarRelacion(int numero, String texto) {
            relaciones.put(numero, texto);
        }

        public String obtenerTexto(int numero) {
            return relaciones.get(numero);
        }

        public void eliminarRelacion(int numero) {
            relaciones.remove(numero);
        }

        // Puedes agregar más métodos según sea necesario...
    }

