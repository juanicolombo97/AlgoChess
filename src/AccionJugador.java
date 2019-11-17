import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();

        //Calculo la distancia de la accion
        int distanciaX, distanciaY;
        Posicion posicionAtacante = atacante.getPosicion();
        Posicion posicionAtacado = atacado.getPosicion();

        distanciaX = posicionAtacante.getPosicionX() - posicionAtacado.getPosicionX();
        distanciaY = posicionAtacante.getPosicionY() - posicionAtacado.getPosicionY();

        accionesFabrica.iniciarAccion(distanciaX,distanciaY,atacante,atacado);
    }
}


