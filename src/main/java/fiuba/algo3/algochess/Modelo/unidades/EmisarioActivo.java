package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class EmisarioActivo implements Emisario{
    private Tablero tablero;

    public EmisarioActivo(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void notificar(Unidad unidad) {
        this.tablero.notificar(unidad);
    }

    @Override
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) {
        return this.tablero.cantidadSoldadosAliadosCercanos(unidad);
    }

    @Override
    public List<Unidad> unidadesEnemigasCercanas(Unidad unidad) {
        return this.tablero.unidadesEnemigasCercanas(unidad);
    }
}
