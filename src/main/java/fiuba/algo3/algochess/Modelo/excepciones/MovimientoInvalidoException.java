package fiuba.algo3.algochess.Modelo.excepciones;

public class MovimientoInvalidoException extends RuntimeException {
    public MovimientoInvalidoException(String msg) {
        super((msg));
    }
}
