package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Tablero;

import java.util.ArrayList;

public class EmisarioReal implements Emisario {
    private Tablero tablero;

    public EmisarioReal(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void notificar(Unidad unidad) throws MovimientoInvalidoException {
        this.tablero.notificar(unidad);
    }

    @Override
    public ArrayList unidadesAliadasCercanas(Unidad unidad){
        return this.tablero.unidadesAliadasCercanas(unidad);
    }

    @Override
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) { return this.tablero.cantidadSoldadosAliadosCercanos(unidad);
    }

    @Override
    public ArrayList unidadesEnemigasCercanas(Unidad unidad){
        return this.tablero.unidadesEnemigasCercanas(unidad);
    }
}
