package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private ArrayList listaDirecciones = direccion.direccionesMovimiento();
    private ArrayList batallonUnidades = new ArrayList();


    public ArrayList unidadesCercanasBatallon(HashMap tablero, ArrayList listaUnidades, Unidad unidadAtacada, int aDistancia) throws CasilleroVacioExcepcion {
        listaUnidades.add(unidadAtacada);
        batallonUnidades.add(unidadAtacada);
        while (listaUnidades.size()!= 0){
            Unidad unidad = (Unidad) listaUnidades.remove(0);
            for (Object direccionActual : listaDirecciones) {
                Direccion direccion = (Direccion) direccionActual;
                Posicion posicionUnidad = unidad.getPosicion();
                Posicion posicionNueva = posicionUnidad.posicionNueva(direccion, aDistancia);
                if (posicionNueva.getPosicionX() > 0 && posicionNueva.getPosicionY() > 0) {
                     Casillero casilleroNuevo = (Casillero) tablero.get(posicionNueva);
                     Unidad unidadNueva;
                     try{unidadNueva = casilleroNuevo.obtenerUnidad();}
                     catch(CasilleroVacioExcepcion | NullPointerException e){continue;}
                    if (!batallonUnidades.contains(unidadNueva)) {
                        batallonUnidades.add(unidadNueva);
                        listaUnidades.add(unidadNueva);
                    }

                }
            }
        }
        return batallonUnidades;
    }

    public ArrayList unidadesCercanas(HashMap tablero, ArrayList listaUnidades, Unidad unidadAtacada, int aDistancia) throws CasilleroVacioExcepcion {
        ArrayList listaUnidadesCercanas = unidadesCercanasBatallon(tablero, listaUnidades, unidadAtacada, aDistancia);
        listaUnidadesCercanas.remove(unidadAtacada);
        return listaUnidadesCercanas;
    }

}




