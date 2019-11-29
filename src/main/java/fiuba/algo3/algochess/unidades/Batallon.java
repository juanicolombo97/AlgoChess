package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();

    public ArrayList calcularBatallon(Unidad unidadAtacada, HashMap tablero) throws CasilleroVacioExcepcion {
        return  unidadesCercanas.unidadesCercanas(tablero,unidades,unidadAtacada);
    }

    public ArrayList calcularBatallonDeSoldados(Unidad unidadAMover,HashMap tablero) throws CasilleroVacioExcepcion {
       ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(tablero,unidades,unidadAMover);
       return listaSoldados(listaUnidades);
    }

    public ArrayList listaSoldados(ArrayList listaUnidades){
        ArrayList<Soldado> listaSoldados = new ArrayList<>();
        for (Object unidadActual : listaUnidades) {
            listaSoldados.add((Soldado) unidadActual);
        }
        return listaSoldados;
    }
}

