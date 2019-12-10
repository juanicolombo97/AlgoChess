package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();

    public List<Unidad> calcularBatallonDeSoldados(Unidad unidadAMover, Map<Posicion, Casillero> tablero, List<Unidad> listaUnidadesAliadas) {
       List<Unidad> listaUnidades = unidadesCercanas.unidadesCercanas(tablero, unidadAMover);
       return listaSoldados(listaUnidades,listaUnidadesAliadas);
    }

    private List<Unidad> listaSoldados(List<Unidad> listaUnidades, List<Unidad> unidadesAliadas) {
        List<Unidad> listaSoldados = new ArrayList<>();
        for (Unidad unidadActual : listaUnidades) {
            if (unidadesAliadas.contains(unidadActual)) {
                unidadActual.agregarSoldadoAListaDeSoldados(listaSoldados);
            }
        }
        return listaSoldados;
    }
}

