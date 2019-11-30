package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.excepciones.CurarException;
import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

import java.util.HashMap;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException, CasilleroVacioExcepcion {
        atacante.atacarDistanciaLejana(atacado,esUnidadAliada,tablero);
    }
}
