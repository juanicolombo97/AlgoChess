import Excepciones.UnidadInvalidaException;

import java.util.HashMap;

public class Jugador {

    private int puntos = 20;
    private HashMap unidadesDisponibles = new HashMap();

    public int getPuntos() {
        return puntos;
    }

    public void modificarPuntos(int puntosASacar){
        puntos -= puntosASacar;
    }
    public HashMap getUnidadesCreadas() {
        return unidadesDisponibles;
    }

    public void atacar(Unidades atacante, Unidades atacado){

    }

    public void mover(Unidades unidadAmover){

    }
    public void crearUnidad(String unidadNueva) throws UnidadInvalidaException {
        UnidadNueva unidad = new UnidadNueva();
        Unidades unidadCreada = unidad.crearUnidad(unidadNueva);
        modificarPuntos(unidadCreada.getCosto());
        unidadesDisponibles.put(unidadCreada,unidadCreada);fefe
    }
}
