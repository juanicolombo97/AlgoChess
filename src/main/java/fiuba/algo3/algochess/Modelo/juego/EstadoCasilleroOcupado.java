package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class EstadoCasilleroOcupado implements EstadoCasillero {

    private Unidad unidad;

    public EstadoCasilleroOcupado(Unidad unidad){
        this.unidad = unidad;
    }
    @Override
    public EstadoCasillero guardarUnidad(Unidad unidad){
        throw new CasilleroOcupadoException("El casillero se encuentra ocupado");
    }

    @Override
    public EstadoCasillero eliminarUnidad() {
        return new EstadoCasilleroVacio();
    }

    @Override
    public Unidad obtenerUnidad() {
        return unidad;
    }

    @Override
    public Unidad obtenerUnidadCercana() {
        return unidad;

    }

}
