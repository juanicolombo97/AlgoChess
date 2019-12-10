package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    } //Solo se usa en Test

    @Override
    public Posicion getPosicion() {
        return posicion;
    } //Se usa en el Modelo, en los Tests y en la Vista

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
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        vidaUnidad -= danioRecibido + (danioRecibido * this.danioExtra);
    }

    @Override
    public int costoDeUnidad() {
        return costoUnidad;
    }

    @Override
    public void curarse(int vidaACurar) {
        vidaUnidad += vidaACurar;
    }

    @Override
    public List<Unidad> habilidadMoverse(Unidad unidadAMover, Map<Posicion, Casillero> tablero, List<Unidad> unidadesAliadas) {
        Batallon batallon = new Batallon();
        List<Unidad> batallonSoldados = batallon.batallonDeSoldados(unidadAMover,tablero,unidadesAliadas);
        if (batallonSoldados.size() < 3){
            List<Unidad> listaUnidad = new ArrayList<>();
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
    public void agregarSoldadoAListaDeSoldados(List<Unidad> listaDeSoldados){
        listaDeSoldados.add(this);
    }

    @Override
    public void agregarUnidadCercana(List<Unidad> batallonUnidades, List<Unidad> listaUnidades) {
        if (!batallonUnidades.contains(this)){
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
    public void verificarEstaViva(ArrayList<Unidad> unidadesDisponibles, Casillero casilleroUnidad) {
        if (vidaUnidad < 0){
            unidadesDisponibles.remove(this);
            casilleroUnidad.eliminarUnidad();
        }
    }
}


