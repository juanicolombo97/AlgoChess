package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class Soldado implements Unidad {
    private static int costoUnidad = 1;
    private double vidaUnidad = 100;
    private static double danioCuerpo = 10;
    private Posicion posicion;
    private Emisario emisario;
    private double danioExtra = 0;

    public Soldado(Puntos puntosJugador, Posicion posicion, Emisario emisario) throws NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        this.posicion = posicion;
        this.emisario = emisario;
        puntosJugador.alcanzanPuntos(costoUnidad);
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
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        vidaUnidad -= danioRecibido + (danioRecibido * this.danioExtra);
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
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) throws MovimientoInvalidoException, CasilleroVacioExcepcion {
        Batallon batallon = new Batallon();
        ArrayList batallonSoldados = batallon.calcularBatallonDeSoldados(unidadAMover,tablero,unidadesAliadas);
        if (batallonSoldados.size() < 3){
            ArrayList listaUnidad = new ArrayList();
            listaUnidad.add(this);
            return listaUnidad;
        }
        else {
            return  batallonSoldados;
        }
    }

    @Override
    public void recibirNotificacion() {

    }

    @Override
    public boolean esSoldado(){ return true; }

    @Override
    public void enCasilleroEnemigo(){
        this.danioExtra = 0.05;
    }

    @Override
    public void enCasilleroAliado(){
        this.danioExtra = 0.00;
    }
}


