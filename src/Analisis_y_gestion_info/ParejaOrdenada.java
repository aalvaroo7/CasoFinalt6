package Analisis_y_gestion_info;

import Gestio_datos_dinamicos.Pareja;

public class ParejaOrdenada<T extends Comparable<T>, U extends Comparable<U>> extends Pareja<T, U> {

    public ParejaOrdenada(T first, U second) {
        super(first, second);
    }

    @Override
    public int compareTo(Pareja<T, U> otraPareja) {
        int comparacionPrimerElemento = this.getFirst().compareTo(otraPareja.getFirst());
        if (comparacionPrimerElemento != 0) {
            return comparacionPrimerElemento;
        } else {
            return this.getSecond().compareTo(otraPareja.getSecond());
        }
    }
}