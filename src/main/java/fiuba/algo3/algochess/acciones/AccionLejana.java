package fiuba.algo3.algochess.acciones;

import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

import java.util.HashMap;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, CasilleroVacioExcepcion {
        atacante.atacarDistanciaLejana(atacado,esUnidadAliada,tablero);
    }
}
