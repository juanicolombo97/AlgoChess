package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.excepciones.CurarException;
import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

import java.util.HashMap;

public class AccionCercana {

    public AccionCercana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException {
        atacante.atacarDistanciaCerca(atacado,esUnidadAliada,tablero, conDanioExtra);
    }

}
