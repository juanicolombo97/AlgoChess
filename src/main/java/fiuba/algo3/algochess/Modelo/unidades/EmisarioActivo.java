package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.juego.Tablero;

import java.util.ArrayList;

public class EmisarioActivo implements Emisario{
    private Tablero tablero;

    public EmisarioActivo(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void notificar(Unidad unidad) throws MovimientoInvalidoException, CasilleroVacioExcepcion {
        this.tablero.notificar(unidad);
    }

    @Override
    public ArrayList unidadesAliadasCercanas(Unidad unidad) throws CasilleroVacioExcepcion {
        return this.tablero.unidadesAliadasCercanas(unidad);
    }

    @Override
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) throws CasilleroVacioExcepcion { return this.tablero.cantidadSoldadosAliadosCercanos(unidad);
    }

    @Override
    public ArrayList unidadesEnemigasCercanas(Unidad unidad) throws CasilleroVacioExcepcion {
        return this.tablero.unidadesEnemigasCercanas(unidad);
    }
}
