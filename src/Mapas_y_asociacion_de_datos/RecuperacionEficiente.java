package Mapas_y_asociacion_de_datos;
import java.util.HashMap;
import java.util.Map;

    public class RecuperacionEficiente<K, V> {
        private Map<K, V> mapa;

        public RecuperacionEficiente() {
            mapa = new HashMap<>();
        }

        public void agregarElemento(K clave, V valor) {
            mapa.put(clave, valor);
        }

        public V recuperarElemento(K clave) {
            return mapa.get(clave);
        }

        public void eliminarElemento(K clave) {
            mapa.remove(clave);
        }

        // Puedes agregar más métodos según sea necesario...
    }

