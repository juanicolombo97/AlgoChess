package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;

import java.util.ArrayList;

public interface Emisario {
    public void notificar(Unidad unidad) throws MovimientoInvalidoException;
    public ArrayList unidadesAliadasCercanas(Unidad unidad);
    public ArrayList unidadesEnemigasCercanas(Unidad unidad);
}
