package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.juego.Posicion;

public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidad crearUnidad(String unidad, Puntos puntosJugador, Posicion posicion) throws fiuba.algo3.algochess.excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidad unidadNueva = unidadesFabrica.crearUnidad(unidad.toLowerCase(),puntosJugador,posicion);
        return unidadNueva;
    }
}
