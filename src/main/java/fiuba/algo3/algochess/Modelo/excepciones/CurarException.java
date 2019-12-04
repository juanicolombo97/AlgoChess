package fiuba.algo3.algochess.Modelo.excepciones;

// Error que se lanza cuando se quiere curar a una catapulta.

public class CurarException extends RuntimeException {
    public CurarException(String msg) {
        super((msg));
    }
}
