package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.acciones.AccionCercana;
import fiuba.algo3.algochess.Modelo.acciones.AccionLejana;
import fiuba.algo3.algochess.Modelo.acciones.AccionMedia;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.Map;

public class Distancia {

    private int distanciaX,distanciaY;

    public Distancia(int distanciaX,int distanciaY){
        this.distanciaX = distanciaX;
        this.distanciaY = distanciaY;
    }


    public Direccion direccionMovimiento() {
        return new Direccion(distanciaX,distanciaY);
    }

    public void calcularDistanciaAccion(Unidad atacante, Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {

        if((distanciaX <= 2) && (distanciaY <= 2)){
            new AccionCercana(atacante,atacado,esUnidadAliada,tablero);
        }
        else if((distanciaX <= 5) && (distanciaY <= 5)){
            new AccionMedia(atacante,atacado,esUnidadAliada,tablero);
        }
        else if((distanciaX >= 6) && (distanciaY >= 6)){
            new AccionLejana(atacante,atacado,esUnidadAliada,tablero);
        }
    }
}
