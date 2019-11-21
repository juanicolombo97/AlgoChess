package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;

import java.util.ArrayList;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();

    public ArrayList calcularBatallon(Unidad unidadAtacada, Casillero[][] arrayCasillero) {
        ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(arrayCasillero,unidades,unidadAtacada);
        return listaUnidades;
    }

}

