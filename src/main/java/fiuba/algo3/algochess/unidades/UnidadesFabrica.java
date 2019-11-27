package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.juego.Posicion;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.
    private Unidad unidadACrear;

    public Unidad crearUnidad(String unidad, Puntos puntosJugador, Posicion posicion) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        switch (unidad) {

            case "soldado": {
                unidadACrear = new Soldado(puntosJugador,posicion);
                break;
            }
            case "jinete": {
                unidadACrear = new Jinete(puntosJugador,posicion);
                break;
            }
            case "curandero": {
                unidadACrear = new Curandero(puntosJugador,posicion);
                break;
            }
            case "catapulta": {
                unidadACrear = new Catapulta(puntosJugador,posicion);
                break;
            }
        }
        return unidadACrear;
    }
}
