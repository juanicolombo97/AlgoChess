package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class Jinete implements Unidad {
    private static int costoUnidad = 3;
    private double vidaUnidad = 100;
    private EstadoJinete estadoJinete = new JineteArquero();
    private Posicion posicion;
    private Emisario emisario;
    private double danioExtra = 0;

    public Jinete( Puntos puntosJugador, Posicion posicion, Emisario emisario) {
        this.posicion = posicion;
        this.emisario = emisario;
        puntosJugador.alcanzanPuntos(costoUnidad);
        recibirNotificacion();
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    public void setEstadoJinete(String estado){
        estadoJinete = (EstadoJinete) estadoJinete.cambiarEstadoJinete(estado);
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
        estadoJinete.atacarDistanciaCerca(atacado);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        estadoJinete.atacarDistanciaMediana(atacado);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        estadoJinete.atacarDistanciaLejana(atacado);
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
        ArrayList listaUnidadesAMover = new ArrayList();
        listaUnidadesAMover.add(this);
        return listaUnidadesAMover;
    }

    @Override
    public void recibirNotificacion() {
        if (this.emisario.cantidadSoldadosAliadosCercanos(this) == 0 && this.emisario.unidadesEnemigasCercanas(this).size() > 0){
            setEstadoJinete("espadachin");
        }
        else if (this.emisario.cantidadSoldadosAliadosCercanos(this) > 0 || this.emisario.unidadesEnemigasCercanas(this).size() == 0){
            setEstadoJinete("arquero");
        }
    }

    public EstadoJinete getEstado(){
        return estadoJinete;
    }

    @Override
    public boolean esSoldado(){ return false; }

    @Override
    public void enCasilleroEnemigo(){
        this.danioExtra = 0.05;
    }

    @Override
    public void enCasilleroAliado(){
        this.danioExtra = 0.00;
    }

}
