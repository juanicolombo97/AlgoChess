package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class EmisarioNulo implements Emisario {
    private Tablero tablero;

    @Override
    public void notificar(Unidad unidad) {

    }

    @Override
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) {
        return 0;
    }

    @Override
    public List<Unidad> unidadesEnemigasCercanas(Unidad unidad) {
        return new ArrayList<>();
    }
}
