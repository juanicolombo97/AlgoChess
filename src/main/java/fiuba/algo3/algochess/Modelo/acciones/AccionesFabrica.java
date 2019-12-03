package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;

public class AccionesFabrica {


    public void iniciarAccion(Unidad atacante, Unidad atacado, HashMap tablero, boolean esUnidadAliada, Distancia distancia, boolean conDanioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException, UnidadInvalidaException, CasilleroVacioExcepcion {

        int distanciaX = distancia.getDistanciaX();
        int distanciaY = distancia.getDistanciaY();

        if((distanciaX <= 2) && (distanciaY <= 2)){
            new AccionCercana(atacante,atacado,esUnidadAliada,tablero, conDanioExtra);
        }
        else if((distanciaX <= 5) && (distanciaY <= 5)){
            new AccionMedia(atacante,atacado,esUnidadAliada,tablero, conDanioExtra);
        }
        else if((distanciaX >= 6) && (distanciaY >= 6)){
            new AccionLejana(atacante,atacado,esUnidadAliada,tablero, conDanioExtra);
        }
    }

}
