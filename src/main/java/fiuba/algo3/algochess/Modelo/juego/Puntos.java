package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorSeQuedoSinPuntosException;

public class Puntos {

    private int puntosDisponibles;

    public Puntos(int puntos){
        puntosDisponibles = puntos;
    }

    public void modificarPuntos(int costoUnidad){
        puntosDisponibles = puntosDisponibles - costoUnidad;
        if (puntosDisponibles == 0){
            actualizarEstado();
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

    public void actualizarEstado() {
      throw new JugadorSeQuedoSinPuntosException("Te haz quedado sin puntos");
    }
}
