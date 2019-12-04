package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private ArrayList listaDirecciones = direccion.direccionesMovimiento();
    private ArrayList batallonUnidades = new ArrayList();

    public ArrayList unidadesCercanas(HashMap tablero, Unidad unidadAtacada){
        ArrayList listaUnidades = new ArrayList();
        listaUnidades.add(unidadAtacada);
        batallonUnidades.add(unidadAtacada);
        while (listaUnidades.size()!= 0){
            Unidad unidad = (Unidad) listaUnidades.remove(0);
            for (Object direccionActual : listaDirecciones) {
                Posicion posicionNueva = unidad.getPosicion().posicionNueva((Direccion) direccionActual);
                    try{
                        Posicion posicion = posicionNueva.posicionValida();
                        Unidad unidadNueva = ((Casillero) tablero.get(posicion)).obtenerUnidad();
                        if (!batallonUnidades.contains(unidadNueva)) {
                            batallonUnidades.add(unidadNueva);
                            listaUnidades.add(unidadNueva);
                        }
                    }catch (CasilleroVacioExcepcion | NullPointerException | MovimientoInvalidoException e){

                    }
                }
            }
        return batallonUnidades;
    }

    public ArrayList unidadesCercanasADistancia(int distanciaLimite, HashMap tablero, Unidad unidadCentral){
        ArrayList unidadesADistanciaCercana = new ArrayList();
        for (int counter = 0; counter < distanciaLimite; counter++){
            for (Object direccionActual : listaDirecciones) {
                Posicion posicionNueva = new Posicion(unidadCentral.getPosicion().posicionNueva((Direccion) direccionActual).posicionX + counter*(((Direccion) direccionActual).getX()),unidadCentral.getPosicion().posicionNueva((Direccion) direccionActual).posicionY + counter*(((Direccion) direccionActual).getY()));
                try{
                    Posicion posicion = posicionNueva.posicionValida();
                    Unidad unidadNueva = ((Casillero) tablero.get(posicion)).obtenerUnidad();
                    unidadesADistanciaCercana.add(unidadNueva);
                }catch (CasilleroVacioExcepcion | NullPointerException | MovimientoInvalidoException e){}
            }
        }
        return unidadesADistanciaCercana;
    }
}
