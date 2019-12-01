package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;

import java.util.ArrayList;

public interface Emisario {
    public void notificar(Unidad unidad) throws MovimientoInvalidoException;
    public ArrayList unidadesAliadasCercanas(Unidad unidad);
    public int cantidadSoldadosAliadosCercanos(Unidad unidad);
    public ArrayList unidadesEnemigasCercanas(Unidad unidad);
}
