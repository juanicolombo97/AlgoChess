package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();

    public ArrayList calcularBatallon(Unidad unidadAtacada, HashMap tablero) throws CasilleroVacioExcepcion {
        ArrayList batallon = unidadesCercanas.unidadesCercanas(tablero, unidades, unidadAtacada);
        if (unidadAtacada.sosSoldado()){
            batallon.add(unidadAtacada);
        }
        return batallon;
    }

    public ArrayList calcularBatallonDeSoldados(Unidad unidadAMover,HashMap tablero) throws CasilleroVacioExcepcion {
       ArrayList listaUnidades = calcularBatallon(unidadAMover, tablero);
       return listaSoldados(listaUnidades);
    }

    public ArrayList listaSoldados(ArrayList listaUnidades){
        ArrayList<Soldado> listaSoldados = new ArrayList<>();
        for (Object unidadActual : listaUnidades) {
            Unidad unidad = (Unidad) unidadActual;
            if (unidad.sosSoldado()) {
                listaSoldados.add((Soldado) unidad);
            }
        }
        return listaSoldados;
    }
}

