package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class Curandero implements Unidad {
    private static int costoUnidad = 2;
    private double vidaUnidad = 75;
    private static int curacion = 15;
    private Posicion posicion;
    private Emisario emisario;


    public Curandero( Puntos puntosJugador, Posicion posicion, Emisario emisario) throws NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroVacioExcepcion {

        this.posicion = posicion;
        this.emisario = emisario;
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public void modificarPosicion(Posicion posicion) throws MovimientoInvalidoException, CasilleroVacioExcepcion {
        this.posicion = posicion;
        this.emisario.notificar(this);
    }

    @Override
    public void recibirNotificacion() {
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        if (!esUnidadAliada){
            throw new CurarException("No se puede curar un enemigo");
        }
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException,CurarException{
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws CurarException, NoPuedeAtacarException {
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
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) throws MovimientoInvalidoException {
        ArrayList listaUnidadesAMover = new ArrayList();
        listaUnidadesAMover.add(this);
        return listaUnidadesAMover;
    }

    @Override
    public boolean esSoldado(){ return false; }

}
