package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class EstadoCasilleroVacio implements EstadoCasillero {

    @Override
    public EstadoCasillero guardarUnidad(Unidad unidad) throws CasilleroOcupadoException {
        return new EstadoCasilleroOcupado(unidad);
    }

    @Override
    public EstadoCasillero eliminarUnidad() throws CasilleroVacioExcepcion {
        throw new CasilleroVacioExcepcion("El casillero esta vacio");
    }

    @Override
    public Unidad obtenerUnidad() throws CasilleroVacioExcepcion {
        throw new CasilleroVacioExcepcion("El casillero esta vacio");
    }
}