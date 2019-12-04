package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;

import java.util.ArrayList;

public interface Emisario {
    public void notificar(Unidad unidad);
    public ArrayList unidadesAliadasCercanas(Unidad unidad);
    public int cantidadSoldadosAliadosCercanos(Unidad unidad);
    public ArrayList unidadesEnemigasCercanas(Unidad unidad);
}
