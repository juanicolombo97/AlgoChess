package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class UnidadNula implements Unidad{
    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public int cuantoCuesta() {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void curarse(int vidaACurar) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public double getVidaUnidad() {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public Posicion getPosicion() {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void modificarPosicion(Posicion posicion) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void recibirNotificacion() {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void setDanioPorCasillero(double danioExtra) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void agregarSoldadoAListaDeSoldados(ArrayList<Soldado> listaDeSoldados) {
        throw new UnidadNulaException("La unidad es inválida");
    }
    @Override
    public void agregarUnidadCercana(ArrayList batallonUnidades, ArrayList listaUnidades) {

    }
    @Override
    public void agregarUnidadADistancia(ArrayList unidadesADistanciaCercana) {

    }
}
