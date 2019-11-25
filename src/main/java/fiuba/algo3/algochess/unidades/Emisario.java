package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;

public interface Emisario {
    public void notificar(int posicionXCentral, int PosicionYCentral) throws MovimientoInvalidoException;
}
