package Mapas_y_asociacion_de_datos;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class IndexadorRecursivo {
    private Map<String, String> indice;

    public IndexadorRecursivo() {
        indice = new HashMap<>();
    }

    public void indexarDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarDirectorio(archivo.getPath());
                } else {
                    indice.put(archivo.getName(), archivo.getPath());
                }
            }
        }
    }

    public String buscarArchivo(String nombreArchivo) {
        return indice.get(nombreArchivo);
    }
}