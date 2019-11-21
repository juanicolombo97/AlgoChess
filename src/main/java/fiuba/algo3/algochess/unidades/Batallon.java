package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Direccion;

import java.util.ArrayList;

public class Batallon {

    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidades = new ArrayList();
    private ArrayList batallonUnidades = new ArrayList();

    public void calcularBatallon(Unidad unidadAtacada, Casillero[][] arrayCasillero) {
        batallonUnidades.add(unidadAtacada);
        ArrayList listaUnidades = unidadesCercanas.unidadesCercanas(arrayCasillero,unidades,unidadAtacada.getPosicion());
    }

}