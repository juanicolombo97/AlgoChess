package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.CurarException;

public class AccionLejana {

    public AccionLejana(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaLejana(atacado);
    }
}
