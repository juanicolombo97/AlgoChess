package fiuba.algo3.algochess.excepciones;

// Error que se lanza cuando se quiere curar a una catapulta.

public class CurarException extends Exception {
    public CurarException(String msg) {
        super((msg));
    }
}