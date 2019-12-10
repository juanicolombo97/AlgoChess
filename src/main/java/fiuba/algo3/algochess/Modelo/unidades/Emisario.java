package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public interface Emisario {
    public void notificar(Unidad unidad);
    public List<Unidad> unidadesAliadasCercanas(Unidad unidad);
    public int cantidadSoldadosAliadosCercanos(Unidad unidad);
    public List<Unidad> unidadesEnemigasCercanas(Unidad unidad);
}
