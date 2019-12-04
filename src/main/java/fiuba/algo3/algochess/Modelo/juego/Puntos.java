package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;

public class Puntos {

    public int puntosDisponibles;

    public Puntos(int puntos){
        puntosDisponibles = puntos;
    }

    public void puntosSuficientes(int costoUnidad){

        puntosDisponibles = puntosDisponibles - costoUnidad;
    }

    public void alcanzanPuntos(int costoUnidad) {
        if (puntosDisponibles < costoUnidad){
            throw new NoAlcanzanLosPuntosException("Puntos insuficientes, dispone de: " + puntosDisponibles);
        }
    }

}
