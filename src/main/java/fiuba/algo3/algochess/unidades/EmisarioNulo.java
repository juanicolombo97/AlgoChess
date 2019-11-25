package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Tablero;

public class EmisarioNulo implements Emisario {
    private Tablero tablero;

    @Override
    public void notificar(Unidad unidad) throws MovimientoInvalidoException {

    }
}
