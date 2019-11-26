package fiuba.algo3.algochess.excepciones;

// Se lanza cuando se quiere crear una fiuba.algo3.algochess.unidades.Unidad invalida.

public class UnidadInvalidaException extends Exception {
    public UnidadInvalidaException(String msg) {
        super((msg));
    }
}
