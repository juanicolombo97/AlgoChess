package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidad crearUnidad(String unidad, Puntos puntosJugador, Posicion posicion, Emisario emisario) {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidad unidadNueva = unidadesFabrica.crearUnidad(unidad.toLowerCase(),puntosJugador,posicion,emisario);
        return unidadNueva;
    }
}
