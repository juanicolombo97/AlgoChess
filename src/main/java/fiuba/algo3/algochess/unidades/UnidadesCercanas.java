package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Direccion;

import java.util.ArrayList;

public class UnidadesCercanas {

    private Direccion direccion = new Direccion(0,0);
    private ArrayList listaDirecciones = direccion.direccionesMovimiento();
    private ArrayList batallonUnidades = new ArrayList();
    private UnidadNula unidadNula = new UnidadNula(0,0);
    int posicionX;
    int posicionY;

    public ArrayList unidadesCercanas(Casillero[][] casilleros, ArrayList listaUnidades, Unidad unidadAtacada, int aDistancia){
        listaUnidades.add(unidadAtacada);
        batallonUnidades.add(unidadAtacada);
        while (listaUnidades.size()!= 0){
            Unidad unidad = (Unidad) listaUnidades.remove(0);
            for (int x = 0; x < listaDirecciones.size();x++){
                posicionX = unidad.getPosicion().getPosicionX() + Math.abs(aDistancia) * ((Direccion)listaDirecciones.get(x)).getX();
                posicionY = unidad.getPosicion().getPosicionY() + Math.abs(aDistancia) * ((Direccion)listaDirecciones.get(x)).getY();
                if (posicionX != 0 && posicionY != 0){
                    Unidad unidadNueva = casilleros[posicionX][posicionY].getUnidad();
                    if (!esUnidadNula(unidadNueva) && !batallonUnidades.contains(unidadNueva)){
                        batallonUnidades.add(unidadNueva);
                        listaUnidades.add(unidadNueva);
                    }

                }
            }
        }
        return batallonUnidades;
    }
    private boolean esUnidadNula(Unidad unidad){
        return unidad.getClass().isInstance(unidadNula);
    }
}
