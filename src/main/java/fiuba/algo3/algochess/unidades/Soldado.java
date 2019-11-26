package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

public class Soldado implements Unidad {
    private static int costoUnidad = 1;
    private double vidaUnidad = 100;
    private static double danioCuerpo = 10;
    private Posicion posicion = new Posicion();
    private Emisario emisario;

    public Soldado(int posicionX,int posicionY, Emisario emisario){
        posicion.posicionNueva(posicionX,posicionY);
        this.emisario = emisario;
    }


    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void modificarPosicion(int posicionX, int posicionY) {
        posicion.posicionNueva(posicionX,posicionY);
    }


    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioCuerpo + (danioCuerpo * danioExtra));
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra, Casillero[][] arrayCasillero) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
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
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.posicionValida(posicionNuevaX,posicionNuevaY);
        emisario.notificar(this);
    }
    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public void recibirNotificacion() {

    }

}


