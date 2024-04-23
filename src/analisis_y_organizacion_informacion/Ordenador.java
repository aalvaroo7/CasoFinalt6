package analisis_y_organizacion_informacion;
import Gestion_de_datos_dinamicos.Pareja;

import Gestion_de_datos_dinamicos.Pareja;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Ordenador {

        public static void ordenarPorPrimerNumero(List<Pareja> datos) {
            Collections.sort(datos, Comparator.comparingInt(Pareja::getPrimerNumero));
        }

        public static void ordenarPorSegundoNumero(List<Pareja> datos) {
            Collections.sort(datos, Comparator.comparingInt(Pareja::getSegundoNumero));
        }

    }