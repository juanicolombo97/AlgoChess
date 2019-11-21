package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

public class UnidadNula implements Unidad {

    private Posicion posicion = new Posicion();

    public UnidadNula(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra, Casillero[][] arrayCasillero) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void recibirDanio(double danioRecibido) throws UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public int cuantoCuesta() {
        return 0;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException {
        throw new UnidadNulaException("fiuba.algo3.algochess.unidades.Unidad invalida");
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public double getVidaUnidad() {
        return 0;
    }

}
