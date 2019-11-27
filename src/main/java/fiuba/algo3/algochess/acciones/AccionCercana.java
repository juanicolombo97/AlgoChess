package fiuba.algo3.algochess.acciones;

import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

import java.util.HashMap;

public class AccionCercana {

    public AccionCercana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException {
        atacante.atacarDistanciaCerca(atacado,esUnidadAliada,tablero);
    }
}
