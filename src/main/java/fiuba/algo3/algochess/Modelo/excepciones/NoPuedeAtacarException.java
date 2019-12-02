package fiuba.algo3.algochess.Modelo.excepciones;

// Error cuando se quiere hacer que una unidad que no pueda atacar ataque.

public class NoPuedeAtacarException extends Exception {
    public NoPuedeAtacarException(String msg) {
        super((msg));
    }
}
