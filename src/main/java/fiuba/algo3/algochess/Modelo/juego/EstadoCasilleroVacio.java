package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.unidades.UnidadNula;

import java.util.concurrent.atomic.AtomicInteger;

public class EstadoCasilleroVacio implements EstadoCasillero {



    @Override
    public EstadoCasillero guardarUnidad(Unidad unidad){
        return new EstadoCasilleroOcupado(unidad);
    }

    @Override
    public EstadoCasillero eliminarUnidad(){
        throw new CasilleroVacioExcepcion("El casillero esta vacio");
    }

    @Override
    public Unidad obtenerUnidad(){
        throw new CasilleroVacioExcepcion("El casillero esta vacio");
    }

    @Override

    public Unidad obtenerUnidadCercana() {
        return new UnidadNula(new Posicion(0,0));
    }

    @Override
    public void guardarUnidadCercana(Unidad unidad, Jugador jugador, Casillero casilleroInicio, AtomicInteger contador, Casillero casilleroFin) {
        casilleroFin.modificarEstadoCasillero(new EstadoCasilleroOcupado(unidad));
        unidad.modificarPosicion(casilleroFin.getPosicionCasillero());
        jugador.unidadModificarPosicionCasillero(unidad,casilleroFin);
        casilleroInicio.eliminarUnidad();
        contador.set(contador.get()+1);

    }

}
