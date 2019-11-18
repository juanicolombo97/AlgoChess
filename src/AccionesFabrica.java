import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionesFabrica {

    public void iniciarAccion(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {

        int distanciaX = atacante.getPosicion().distanciaXHasta(atacado.getPosicion());
        int distanciaY = atacante.getPosicion().distanciaYHasta(atacado.getPosicion());

        if((-2 <= distanciaX && distanciaX <= 2) && (-2 <= distanciaY && distanciaY <= 2)){
            new AccionCercana(atacante,atacado);
        }
        else if((-5 <= distanciaX && distanciaX <= 5) && (-5 <= distanciaY && distanciaY <= 5)){
            new AccionMedia(atacante,atacado);
        }
        else if((-6 >= distanciaX || distanciaX  >= 6) && (-6 >= distanciaY || distanciaY >= 6)){
            new AccionLejana(atacante,atacado);
        }
    }
}
