package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CasilleroEnemigoException;
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
}
