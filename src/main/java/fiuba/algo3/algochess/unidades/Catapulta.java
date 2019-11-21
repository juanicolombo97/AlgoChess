package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;

//Clase donde se implementa la Unidad Catapulta

public class Catapulta implements Unidad {
    private static int costoUnidad = 5;
    private double vidaUnidad = 50;
    private static double danioDistancia = 20;
    private Posicion posicion = new Posicion();

    public Catapulta(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioDistancia);
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
        throw new CurarException("La catapulta no puede ser curada");
    }
    @Override
    public void moverUnidad(Direccion direccion) throws UnidadNulaException, MovimientoInvalidoException {
        throw new MovimientoInvalidoException("La catapulta no se puede mover");
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}