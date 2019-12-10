package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void setEstadoJinete(String estado){ //temporal, sacar ifs con refactor de recibirNotificacion()
        if(estado.equals("arquero")){
            this.estadoJinete = this.estadoJinete.setEstadoJineteArquero();
        }else if(estado.equals("espadachin")){
            this.estadoJinete = this.estadoJinete.setEstadoJineteEspadachin();
        }
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
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        estadoJinete.atacarDistanciaCerca(atacado);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        estadoJinete.atacarDistanciaMediana(atacado);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
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
    public List<Unidad> habilidadMoverse(Unidad unidadAMover, Map<Posicion, Casillero> tablero, List<Unidad> unidadesAliadas) {
        List<Unidad> listaUnidadesAMover = new ArrayList<>();
        listaUnidadesAMover.add(this);
        return listaUnidadesAMover;
    }

    @Override
    public void recibirNotificacion() {
        if (this.emisario.cantidadSoldadosAliadosCercanos(this) == 0 && this.emisario.unidadesEnemigasCercanas(this).size() > 0){
            setEstadoJineteEspadachin();
        }
        else if (this.emisario.cantidadSoldadosAliadosCercanos(this) > 0 || this.emisario.unidadesEnemigasCercanas(this).size() == 0){
            setEstadoJineteArquero();
        }
    }

    private void setEstadoJineteArquero() {
        estadoJinete = estadoJinete.setEstadoJineteArquero();
    }

    private void setEstadoJineteEspadachin() {
        estadoJinete = estadoJinete.setEstadoJineteEspadachin();
    }

    public EstadoJinete getEstado(){
        return estadoJinete;
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

    @Override
    public Posicion calcularPosicionCercana(Direccion direccionActual, int counter) {
        Posicion posicionNueva = posicion.posicionNueva(direccionActual);
        return posicionNueva.posicionNuevaCercana(direccionActual,counter);
    }

    @Override
    public void sigueViva(List<Unidad> unidadesDisponibles) {
        if (vidaUnidad > 0){
            unidadesDisponibles.add(this);
        }
    }

}
