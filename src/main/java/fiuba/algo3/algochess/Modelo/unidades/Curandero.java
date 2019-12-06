package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Curandero implements Unidad {
    private static int costoUnidad = 2;
    private double vidaUnidad = 75;
    private static int curacion = 15;
    private Posicion posicion;
    private Emisario emisario;
    private double danioExtra = 0;


    public Curandero( Puntos puntosJugador, Posicion posicion, Emisario emisario) {
        puntosJugador.alcanzanPuntos(costoUnidad);
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
    public void modificarPosicion(Posicion posicion) {
        this.posicion = posicion;
        this.emisario.notificar(this);
    }

    @Override
    public void recibirNotificacion() {
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        if (!esUnidadAliada){
            throw new CurarException("No se puede curar un enemigo");
        }
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
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
    public List<Unidad> habilidadMoverse(Unidad unidadAMover, Map<Posicion, Casillero> tablero, List<Unidad> unidadesAliadas) {
        List<Unidad> listaUnidadesAMover = new ArrayList<>();
        listaUnidadesAMover.add(this);
        return listaUnidadesAMover;
    }

    @Override
    public void setDanioPorCasillero(double danioExtra) {
        this.danioExtra = danioExtra;
    }

    @Override
    public void agregarSoldadoAListaDeSoldados(List<Unidad> listaDeSoldados){

    }

    @Override
    public void agregarUnidadCercana(List<Unidad> batallonUnidades, List<Unidad> listaUnidades) {
        if(!batallonUnidades.contains(this)){
            batallonUnidades.add(this);
            listaUnidades.add(this);
        }
    }
    @Override
    public void agregarUnidadADistancia(List<Unidad> unidadesADistanciaCercana) {
        unidadesADistanciaCercana.add(this);
    }
}
