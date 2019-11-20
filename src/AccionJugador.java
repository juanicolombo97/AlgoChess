import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();
        accionesFabrica.iniciarAccion(atacante,atacado);
    }
}

