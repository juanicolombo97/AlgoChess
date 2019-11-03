package Excepciones;

// Error que se lanza cuando se quiere curar a una catapulta.

public class CurarCatapultaException extends Exception {
    public CurarCatapultaException(String msg) {
        super((msg));
    }
}
