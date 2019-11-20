package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacante.atacarDistanciaLejana(atacado,danioExtra);
    }
}