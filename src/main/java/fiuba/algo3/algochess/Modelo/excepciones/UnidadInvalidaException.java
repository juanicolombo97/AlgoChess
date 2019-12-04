package fiuba.algo3.algochess.Modelo.excepciones;

// Se lanza cuando se quiere crear una fiuba.algo3.algochess.Modelo.unidades.Unidad invalida.

public class UnidadInvalidaException extends RuntimeException {
    public UnidadInvalidaException(String msg) {
        super((msg));
    }
}
