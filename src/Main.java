import Gestio_datos_dinamicos.InterfazUsuario;
import Gestio_datos_dinamicos.Pareja;
import Gestio_datos_dinamicos.Modelo_multidimensional;

public class Main {
    public static void main(String[] args) {
        Modelo_multidimensional modelo = new Modelo_multidimensional();

        // Agregar pares de enteros al modelo
        modelo.agregarParejaEnteros(new Pareja<>(1, 2));
        modelo.agregarParejaEnteros(new Pareja<>(3, 4));
        modelo.agregarParejaEnteros(new Pareja<>(5, 6));

        // Agregar pares de datos reales al modelo
        modelo.agregarParejaReales(new Pareja<>(1.1, 2.2));
        modelo.agregarParejaReales(new Pareja<>(3.3, 4.4));
        modelo.agregarParejaReales(new Pareja<>(5.5, 6.6));

        // Imprimir las listas del modelo
        modelo.imprimirListas();
    }

    public static void main(String[] args) {
        // Crear una instancia de la interfaz de usuario
        new InterfazUsuario();
}