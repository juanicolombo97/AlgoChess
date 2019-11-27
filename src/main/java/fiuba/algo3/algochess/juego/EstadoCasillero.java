package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.unidades.Unidad;

public interface EstadoCasillero {

    public EstadoCasillero guardarUnidad(Unidad unidad) throws CasilleroOcupadoException;
    public EstadoCasillero eliminarUnidad() throws CasilleroVacioExcepcion;
    public Unidad obtenerUnidad() throws CasilleroVacioExcepcion;
}
