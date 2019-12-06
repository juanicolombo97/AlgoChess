package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.excepciones.CurarException;
import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

import java.util.HashMap;
import java.util.Map;

public class AccionMedia {

    public AccionMedia(Unidad atacante, Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        atacante.atacarDistanciaMediana(atacado,esUnidadAliada,tablero);
    }
}
