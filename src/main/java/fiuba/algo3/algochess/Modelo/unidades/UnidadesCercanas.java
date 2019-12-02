package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private ArrayList listaDirecciones = direccion.direccionesMovimiento();
    private ArrayList batallonUnidades = new ArrayList();

    public ArrayList unidadesCercanas(HashMap tablero, ArrayList listaUnidades, Unidad unidadAtacada) throws CasilleroVacioExcepcion {
        listaUnidades.add(unidadAtacada);
        batallonUnidades.add(unidadAtacada);
        while (listaUnidades.size()!= 0){
            Unidad unidad = (Unidad) listaUnidades.remove(0);
            for (Object direccionActual : listaDirecciones) {
                Posicion posicionNueva = unidad.getPosicion().posicionNueva((Direccion) direccionActual);
                if (posicionNueva.getPosicionY() > 0 && posicionNueva.getPosicionY() > 0) {
                    try{
                        Unidad unidadNueva = ((Casillero) tablero.get(posicionNueva)).obtenerUnidad();
                        if (!batallonUnidades.contains(unidadNueva)) {
                            batallonUnidades.add(unidadNueva);
                            listaUnidades.add(unidadNueva);
                        }
                    }catch (CasilleroVacioExcepcion | NullPointerException e){

                    }
                }
            }
        }
        return batallonUnidades;
    }

    public ArrayList unidadesCercanasADistancia(int distanciaLimite, HashMap tablero, Unidad unidadAtacada){
        ArrayList unidadesADistanciaCercana = new ArrayList();
        for (int counter = 0; counter < distanciaLimite; counter++){
            for (Object direccionActual : listaDirecciones) {
                Posicion posicionNueva = unidadAtacada.getPosicion().posicionNueva((Direccion) direccionActual);
                if (counter) {
                    posicionNueva = unidadAtacada.getPosicion().posicionNueva((Direccion) direccionActual);
                }
                if (posicionNueva.getPosicionY() > 0 && posicionNueva.getPosicionY() > 0) {
                    try{
                        Unidad unidadNueva = ((Casillero) tablero.get(posicionNueva)).obtenerUnidad();
                        if (!batallonUnidades.contains(unidadNueva)) {
                            unidadesADistanciaCercana.add(unidadNueva);
                        }
                    }catch (CasilleroVacioExcepcion | NullPointerException e){

                    }
                }
            }
        }
        return unidadesADistanciaCercana;
    }

}
