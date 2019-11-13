package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.CurarException;

public class AccionCercana {

    public AccionCercana(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaCerca(atacado);
    }
}
