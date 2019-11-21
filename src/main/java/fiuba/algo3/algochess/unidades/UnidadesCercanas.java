package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;

import java.util.ArrayList;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private ArrayList listaDirecciones = direccion.direccionesMovimiento();
    private UnidadNula unidadNula = new UnidadNula(0,0);
    int posicionX;
    int posicionY;

    public ArrayList unidadesCercanas(Casillero[][] casilleros, ArrayList listaUnidades, Posicion posicion){
        for (int x = 0; x < listaDirecciones.size(); x++) {
            posicionX = posicion.getPosicionX() + ((Direccion) listaDirecciones.get(x)).getX();
            posicionY = posicion.getPosicionY() + ((Direccion) listaDirecciones.get(x)).getY();
            if (posicionX != 0 && posicionY != 0) {
                Unidad unidadCercana = casilleros[posicionX][posicionY].getUnidad();
                if (!esUnidadNula(unidadCercana) && !listaUnidades.contains(unidadCercana)) {
                    listaUnidades.add(unidadCercana);
                }
            }
        }
        return listaUnidades;
    }
    private boolean esUnidadNula(Unidad unidad){
        return unidad.getClass().isInstance(unidadNula);
    }
}
