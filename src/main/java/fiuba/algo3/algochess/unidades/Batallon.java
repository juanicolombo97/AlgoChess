package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;

import java.util.ArrayList;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();
    private Soldado soldado = new Soldado(0,0, new EmisarioNulo());

    public ArrayList calcularBatallon(Unidad unidadAtacada, Casillero[][] arrayCasillero) {
        ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(arrayCasillero,unidades,unidadAtacada);
        return listaUnidades;
    }

    public ArrayList calcularBatallonDeSoldados(Unidad unidadAMover,Casillero[][] casilleros){
        ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(casilleros,unidades,unidadAMover);
        ArrayList batallonSoldado = new ArrayList();
        for (int x = 0; x < listaUnidades.size();x++){
            Unidad unidad = (Unidad) listaUnidades.get(x);
            if (unidad.getClass().equals(soldado.getClass())){
                batallonSoldado.add(unidad);
            }
        }
        return batallonSoldado;
    }
}

