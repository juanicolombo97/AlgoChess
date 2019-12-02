package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();

    public ArrayList calcularBatallon(Unidad unidadAtacada, HashMap tablero) throws CasilleroVacioExcepcion {
        return  unidadesCercanas.unidadesCercanas(tablero,unidades,unidadAtacada);
    }

    public ArrayList calcularBatallonDeSoldados(Unidad unidadAMover,HashMap tablero,ArrayList listaUnidadesAliadas) throws CasilleroVacioExcepcion {
       ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(tablero,unidades,unidadAMover);
       return listaSoldados(listaUnidades,listaUnidadesAliadas);
    }

    private ArrayList listaSoldados(ArrayList listaUnidades,ArrayList unidadesAliadas) {
        ArrayList<Soldado> listaSoldados = new ArrayList<>();
        for (int x = 0; x < listaUnidades.size(); x++) {
            Unidad unidad = (Unidad) listaUnidades.get(x);
            if (unidadesAliadas.contains(unidad)) {
                try {
                    listaSoldados.add((Soldado) unidad);
                }catch (ClassCastException e) {
                }
            }
        }
        return listaSoldados;
    }
}

