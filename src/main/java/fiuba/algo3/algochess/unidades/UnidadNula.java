package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;

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
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
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
    public void moverUnidad(Direccion direccion) throws UnidadNulaException {
        throw new UnidadNulaException("Unidad invalida");
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}