package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;
import java.util.Map;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        atacante.atacarDistanciaLejana(atacado,esUnidadAliada,tablero);
    }
}
