package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();

    public ArrayList calcularBatallonDeSoldados(Unidad unidadAMover,HashMap tablero,ArrayList listaUnidadesAliadas) {
       ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(tablero, unidadAMover);
       return listaSoldados(listaUnidades,listaUnidadesAliadas);
    }

    private ArrayList listaSoldados(ArrayList listaUnidades,ArrayList unidadesAliadas) {
        ArrayList<Soldado> listaSoldados = new ArrayList<>();
        for (Object unidad : listaUnidades) {
            Unidad unidadActual = (Unidad) unidad;
            if (unidadesAliadas.contains(unidadActual)) {
                unidadActual.agregarSoldadoAListaDeSoldados(listaSoldados);
            }
        }
        return listaSoldados;
    }
}

