package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.concurrent.atomic.AtomicInteger;

public interface EstadoCasillero {

    public EstadoCasillero guardarUnidad(Unidad unidad);
    public EstadoCasillero eliminarUnidad();
    public Unidad obtenerUnidad();
    public Unidad obtenerUnidadCercana();

    void guardarUnidadCercana(Unidad unidad, Jugador jugador, Casillero casilleroInicio, AtomicInteger contador, Casillero casillero);
}
