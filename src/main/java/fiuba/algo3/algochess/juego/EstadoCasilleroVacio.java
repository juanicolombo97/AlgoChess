package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.unidades.Unidad;

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
