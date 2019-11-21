import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionesFabrica {

    public void iniciarAccion(Unidad atacante, Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {

        int distanciaX = atacante.getPosicion().distanciaXHasta(atacado.getPosicion());
        int distanciaY = atacante.getPosicion().distanciaYHasta(atacado.getPosicion());

        if((distanciaX <= 2) && (distanciaY <= 2)){
            new AccionCercana(atacante,atacado,danioExtra);
        }
        else if((distanciaX <= 5) && (distanciaY <= 5)){
            new AccionMedia(atacante,atacado,danioExtra);
        }
        else {
            new AccionLejana(atacante,atacado,danioExtra);
        }
    }
}
