import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class AccionesFabrica {

    public void iniciarAccion(int distanciaX,int distanciaY,Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {

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
