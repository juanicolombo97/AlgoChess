package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado, HashMap tablero, boolean esUnidadAliada, Distancia distancia, boolean conDanioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException, CasilleroVacioExcepcion {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();
        accionesFabrica.iniciarAccion(atacante,atacado,tablero,esUnidadAliada,distancia,conDanioExtra);
    }

}


