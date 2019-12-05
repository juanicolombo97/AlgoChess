package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorSeQuedoSinPuntosException;

public class Puntos {

    private int puntosDisponibles;

    public Puntos(int puntos){
        puntosDisponibles = puntos;
    }

    public void puntosSuficientes(int costoUnidad){
        puntosDisponibles = puntosDisponibles - costoUnidad;
        if (puntosDisponibles == 0){
            throw new JugadorSeQuedoSinPuntosException("Te haz quedado sin puntos");
        }
    }

    public void alcanzanPuntos(int costoUnidad) {
        if (puntosDisponibles < costoUnidad){
            throw new NoAlcanzanLosPuntosException("Puntos insuficientes, dispone de: " + puntosDisponibles);
        }
    }

    public int getPuntosDisponibles(){
        return this.puntosDisponibles;
    }

}
