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

    public Soldado(Puntos puntosJugador, Posicion posicion, Emisario emisario) {
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
    public void modificarPosicion(Posicion posicion) {
        this.posicion = posicion;
        this.emisario.notificar(this);
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
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
    public void curarse(int vidaACurar) {
        vidaUnidad += vidaACurar;
    }

    @Override
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) {
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
    public void setDanioPorCasillero(double danioExtra) {
        this.danioExtra = danioExtra;
    }

    @Override
    public void agregarSoldadoAListaDeSoldados(ArrayList<Soldado> listaDeSoldados){
        listaDeSoldados.add(this);
    }

    @Override
    public void agregarUnidadCercana(ArrayList batallonUnidades, ArrayList listaUnidades) {
        batallonUnidades.add(this);
        listaUnidades.add(this);
    }

    @Override
    public void agregarUnidadADistancia(ArrayList unidadesADistanciaCercana) {
        unidadesADistanciaCercana.add(this);
    }
}


