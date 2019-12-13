package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;
import java.util.Map;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado, Map<Posicion, Casillero> tablero, boolean esUnidadAliada, Distancia distancia) {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();
        accionesFabrica.iniciarAccion(atacante,atacado,tablero,esUnidadAliada,distancia);

    }
}


