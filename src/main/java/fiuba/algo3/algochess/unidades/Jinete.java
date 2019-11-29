package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.juego.Posicion;

import java.util.HashMap;

public class Jinete implements Unidad {
    private static int costoUnidad = 3;
    private double vidaUnidad = 100;
    private int danioCercano = 5;
    private int danioMediano = 15;
    private Posicion posicion;

    public Jinete( Puntos puntosJugador, Posicion posicion) throws NoAlcanzanLosPuntosException {
        puntosJugador.puntosSuficientes(costoUnidad);
        this.posicion = posicion;
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public void modificarPosicion(Posicion posicion) {
        this.posicion = posicion;
    }




    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
       atacado.recibirDanio(danioCercano);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        atacado.recibirDanio(danioMediano);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias lejanas");
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
    public void habilidadMoverse() {

    }

    @Override
    public boolean sosSoldado(){
        return false;
    }
    @Override
    public void recibirNotificacion(){}
}
