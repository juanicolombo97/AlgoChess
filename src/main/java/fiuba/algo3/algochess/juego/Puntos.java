package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;

public class Puntos {

    private int puntosDisponibles;

    public Puntos(int puntos){
        puntosDisponibles = puntos;
    }

    public void puntosSuficientes(int costoUnidad) throws NoAlcanzanLosPuntosException {
        if (puntosDisponibles - costoUnidad < 0){
            throw new NoAlcanzanLosPuntosException("Puntos insuficientes, dispone de: " + puntosDisponibles);
        }
        puntosDisponibles = puntosDisponibles - costoUnidad;
    }


}
