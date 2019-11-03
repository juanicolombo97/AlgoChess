package Excepciones;

// Se lanza cuando se quiere crear una Unidad invalida.

public class UnidadInvalidaException extends Exception {
    public UnidadInvalidaException(String msg) {
        super((msg));
    }
}
