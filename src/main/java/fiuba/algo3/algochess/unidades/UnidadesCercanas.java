package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Direccion;

import java.util.ArrayList;

public class UnidadesCercanas {
    private Direccion direcciones = new Direccion("nula");
    private ArrayList listaDirecciones = direcciones.direccionesMovimiento();
    private UnidadNula unidadNula = new UnidadNula(0,0);

    public void unidadesCercanas(Unidad unidad, ArrayList listaUnidades, Casillero[][] arrayCasillero){

        while (listaDirecciones.size() != 0){
            Direccion direccion = (Direccion) listaDirecciones.remove(0);
            int x = direccion.getX() + unidad.getPosicion().getPosicionX();
            int y = direccion.getY() + unidad.getPosicion().getPosicionY();
            if(x<= 0 || y <= 0){
                continue;
            }
            Unidad unidadCercana = arrayCasillero[x][y].getUnidad();
            if (!unidadCercana.getClass().equals(unidadNula.getClass())) {
                listaUnidades.add(unidadCercana);
            }
        }
    }
}