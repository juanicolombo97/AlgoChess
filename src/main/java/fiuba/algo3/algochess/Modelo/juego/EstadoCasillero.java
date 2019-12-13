package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.concurrent.atomic.AtomicInteger;

public interface EstadoCasillero {

     EstadoCasillero guardarUnidad(Unidad unidad);
     EstadoCasillero eliminarUnidad();
     Unidad obtenerUnidad();
     Unidad obtenerUnidadCercana();
     void guardarUnidadDesdeCasillero(Casillero casilleroInicial, Casillero casilleroDestino, Jugador jugador, Unidad unidad);
    void guardarUnidadCercana(Unidad unidad, Jugador jugador, Casillero casilleroInicio, AtomicInteger contador, Casillero casillero);
}
