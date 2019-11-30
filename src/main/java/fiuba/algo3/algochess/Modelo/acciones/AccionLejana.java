package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, CasilleroVacioExcepcion, UnidadInvalidaException {
        atacante.atacarDistanciaLejana(atacado,esUnidadAliada,tablero);
    }
}
