package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Tablero;

public class EmisarioReal implements Emisario {
    private Tablero tablero;

    public EmisarioReal(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void notificar(int posicionXCentral, int PosicionYCentral) throws MovimientoInvalidoException {
        this.tablero
    }
}
