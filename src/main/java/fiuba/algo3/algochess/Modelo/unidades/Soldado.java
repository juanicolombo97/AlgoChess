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

    public Soldado(Puntos puntosJugador, Posicion posicion, Emisario emisario) throws NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroVacioExcepcion {
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
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        atacado.recibirDanio(danioCuerpo, conDanioExtra);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero, boolean conDanioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
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
}


