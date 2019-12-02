package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;

public class Puntos {

    public int puntosDisponibles;

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
