package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

//Clase donde se implementa la fiuba.algo3.algochess.Modelo.unidades.Unidad fiuba.algo3.algochess.Modelo.unidades.Catapulta

public class Catapulta implements Unidad{
    private static int costoUnidad = 5;
    private double vidaUnidad = 50;
    private static double danioDistancia = 20;
    private Batallon batallon = new Batallon();
    private Posicion posicion;
    private Emisario emisario;


    public Catapulta(Puntos puntosJugador, Posicion posicion, Emisario emisario) throws NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroVacioExcepcion {
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
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException, UnidadNulaException, CasilleroVacioExcepcion {
        Batallon batallon = new Batallon();
        ArrayList unidadesAAtacar = batallon.calcularBatallon(atacado,tablero);
        for (Object unidad : unidadesAAtacar){
            ( (Unidad) unidad).recibirDanio(danioDistancia, conDanioExtra);
        }
    }

    @Override
    public void recibirDanio(double danioRecibido, boolean conDanioExtra) {
        if (conDanioExtra){
            vidaUnidad -= (danioRecibido * 0.05);
        }
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
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) throws MovimientoInvalidoException {
        throw new MovimientoInvalidoException("La catapulta no se puede mover");
    }

    @Override
    public boolean esSoldado(){ return false; }

}