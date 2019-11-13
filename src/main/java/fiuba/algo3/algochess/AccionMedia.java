package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;

public class AccionMedia {

    public AccionMedia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaMediana(atacado);
    }
}
