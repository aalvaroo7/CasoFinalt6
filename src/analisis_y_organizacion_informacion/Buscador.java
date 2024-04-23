package analisis_y_organizacion_informacion;

import Gestion_de_datos_dinamicos.Pareja;

import java.util.List;

public class Buscador {

    public static int buscarPareja(List<Pareja> datos, int primerNumero, int segundoNumero) {
        for (int i = 0; i < datos.size(); i++) {
            Pareja pareja = datos.get(i);
            if (pareja.getPrimerNumero() == primerNumero && pareja.getSegundoNumero() == segundoNumero) {
                return i;
            }
        }
        return -1;
    }

}