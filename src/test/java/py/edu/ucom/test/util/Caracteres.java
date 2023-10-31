package py.edu.ucom.test.util;


public class Caracteres {
    public static String limpiarYCapitalizar(String texto) {
        String textoLimpio = texto.replaceAll("[^a-zA-Z]", "");
        textoLimpio = textoLimpio.substring(0, 1).toUpperCase() + textoLimpio.substring(1).toLowerCase();
        return textoLimpio;

    }

}