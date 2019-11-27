package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.unidades.Unidad;

public class EstadoCasilleroOcupado implements EstadoCasillero {

    private Unidad unidad;

    public EstadoCasilleroOcupado(Unidad unidad){
        this.unidad = unidad;
    }
    @Override
    public EstadoCasillero guardarUnidad(Unidad unidad) throws CasilleroOcupadoException {
        throw new CasilleroOcupadoException("El casillero se encuentra ocupado");
    }

    @Override
    public EstadoCasillero eliminarUnidad() {
        this.unidad = null;
        return new EstadoCasilleroVacio();
    }

    @Override
    public Unidad obtenerUnidad() {
        return unidad;
    }
}
