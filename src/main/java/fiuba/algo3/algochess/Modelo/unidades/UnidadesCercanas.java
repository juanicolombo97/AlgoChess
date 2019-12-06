package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private List<Direccion> listaDirecciones = direccion.direccionesMovimiento();
    private List<Unidad> batallonUnidades = new ArrayList<>();

    public List<Unidad> unidadesCercanas(Map<Posicion, Casillero> tablero, Unidad unidadAtacada){
        List<Unidad> listaUnidades = new ArrayList<>();
        listaUnidades.add(unidadAtacada);
        batallonUnidades.add(unidadAtacada);
        while (listaUnidades.size()!= 0){
            Unidad unidad = listaUnidades.remove(0);
            for (Direccion direccionActual : listaDirecciones) {
                Posicion posicionNueva = unidad.getPosicion().posicionNueva(direccionActual);
                posicionNueva.posicionValidaParaFormarBatallon(tablero,batallonUnidades,listaUnidades);
            }
        }
        return batallonUnidades;
    }

    public List<Unidad> unidadesCercanasADistancia(int distanciaLimite, Map<Posicion, Casillero> tablero, Unidad unidadCentral){
        List<Unidad> unidadesADistanciaCercana = new ArrayList<>();
        for (int counter = 0; counter < distanciaLimite; counter++){
            for (Direccion direccionActual : listaDirecciones) {
                Posicion posicionNueva = new Posicion(unidadCentral.getPosicion().posicionNueva(direccionActual).posicionX + counter*((direccionActual).getX()),unidadCentral.getPosicion().posicionNueva(direccionActual).posicionY + counter*((direccionActual).getY()));
                posicionNueva.determinarPosicionValida(tablero, unidadesADistanciaCercana);
            }
        }
        return unidadesADistanciaCercana;
    }
}
