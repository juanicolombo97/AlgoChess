package fiuba.algo3.algochess.acciones;

import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

public class AccionJugador {

    public void accionNueva(Unidad atacante, Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        //Creo fabrica Acciones.
        AccionesFabrica accionesFabrica = new AccionesFabrica();
        accionesFabrica.iniciarAccion(atacante,atacado,danioExtra);
    }
}


