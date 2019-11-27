package fiuba.algo3.algochess.acciones;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Distancia;
import fiuba.algo3.algochess.unidades.Unidad;

import java.util.HashMap;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado, HashMap tablero, boolean esUnidadAliada, Distancia distancia, HashMap hashMap) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException, CasilleroVacioExcepcion {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();
        accionesFabrica.iniciarAccion(atacante,atacado,tablero,esUnidadAliada,distancia,tablero);
    }
}


