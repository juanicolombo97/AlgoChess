package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Tablero;

import java.util.ArrayList;

public class EmisarioNulo implements Emisario {
    private Tablero tablero;

    @Override
    public void notificar(Unidad unidad) throws MovimientoInvalidoException {

    }

    @Override
    public ArrayList unidadesAliadasCercanas(Unidad unidad) {
        ArrayList listaNula = new ArrayList();
        return listaNula;
    }

    @Override
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) {
        return 0;
    }

    @Override
    public ArrayList unidadesEnemigasCercanas(Unidad unidad) {
        ArrayList listaNula = new ArrayList();
        return listaNula;
    }
}
