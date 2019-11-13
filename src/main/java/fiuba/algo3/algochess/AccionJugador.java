package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.CurarException;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();

        //Calculo la distancia de la accion
        int distanciaX, distanciaY;
        distanciaX = atacante.posicionEnX() - atacado.posicionEnX();
        distanciaY = atacante.posicionEnY() - atacado.posicionEnY();

        accionesFabrica.iniciarAccion(distanciaX,distanciaY,atacante,atacado);
    }
}
