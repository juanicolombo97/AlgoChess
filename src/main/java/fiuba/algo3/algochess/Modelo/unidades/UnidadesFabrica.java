package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

public class UnidadesFabrica {

    public Unidad crearUnidad(String unidad, Puntos puntosJugador, Posicion posicion, Emisario emisario) {
        //Fabrica utilizada para crear las unidades del juego.
        Unidad unidadACrear;
        switch (unidad) {

            case "soldado": {
                unidadACrear = new Soldado(puntosJugador,posicion,emisario);
                break;
            }
            case "jinete": {
                unidadACrear = new Jinete(puntosJugador,posicion,emisario);
                break;
            }
            case "curandero": {
                unidadACrear = new Curandero(puntosJugador,posicion,emisario);
                break;
            }
            case "catapulta": {
                unidadACrear = new Catapulta(puntosJugador,posicion,emisario);
                break;
            }
            default:
                throw new UnidadInvalidaException("La unidad es invalida");
        }
        return unidadACrear;
    }
}
