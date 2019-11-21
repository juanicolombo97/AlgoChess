package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;

public class Curandero implements Unidad {
    private static int costoUnidad = 2;
    private double vidaUnidad = 75;
    private static int curacion = 15;
    private Posicion posicion = new Posicion();

    public Curandero(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException,CurarException{
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws CurarException, NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        vidaUnidad -= danioRecibido;
    }

    @Override
    public int cuantoCuesta() {
        return costoUnidad;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException {
        vidaUnidad += vidaACurar;
    }

    @Override
    public void moverUnidad(Direccion direccion) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.movimientoHacia(direccion.getX(),direccion.getY());
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}
