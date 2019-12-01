package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;

import java.util.ArrayList;

public interface Emisario {
    public void notificar(Unidad unidad) throws MovimientoInvalidoException, CasilleroVacioExcepcion;
    public ArrayList unidadesAliadasCercanas(Unidad unidad) throws CasilleroVacioExcepcion;
    public int cantidadSoldadosAliadosCercanos(Unidad unidad) throws CasilleroVacioExcepcion;
    public ArrayList unidadesEnemigasCercanas(Unidad unidad) throws CasilleroVacioExcepcion;
}
