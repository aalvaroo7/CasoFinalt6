package Mapas_y_asociacion_datos;

import java.util.HashMap;
import java.util.Map;

public class RelacionesDeDatos {
    private Map<Integer, Character> numberToLetterMap;
    private Map<Integer, String> numberToTextualRepresentationMap;

    public RelacionesDeDatos() {
        numberToLetterMap = new HashMap<>();
        numberToTextualRepresentationMap = new HashMap<>();
    }

    public void addNumberToLetterMapping(int number, char letter) {
        numberToLetterMap.put(number, letter);
    }

    public void addNumberToTextualRepresentationMapping(int number, String textualRepresentation) {
        numberToTextualRepresentationMap.put(number, textualRepresentation);
    }

    public char getLetterByNumber(int number) {
        return numberToLetterMap.get(number);
    }

    public String getTextualRepresentationByNumber(int number) {
        return numberToTextualRepresentationMap.get(number);
    }
}