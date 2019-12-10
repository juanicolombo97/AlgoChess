package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnidadNula implements Unidad{

    private  Posicion posicion;

    public UnidadNula(Posicion posicion){
        this.posicion = posicion;
    }
    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
        throw new UnidadNulaException("La unidad es inválida");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, Map<Posicion, Casillero> tablero) {
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
    public List<Unidad> habilidadMoverse(Unidad unidadAMover, Map<Posicion, Casillero> tablero, List<Unidad> unidadesAliadas) {
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
    public void agregarSoldadoAListaDeSoldados(List<Unidad> listaDeSoldados) {
        throw new UnidadNulaException("La unidad es inválida");
    }
    @Override
    public void agregarUnidadCercana(List<Unidad> batallonUnidades, List<Unidad> listaUnidades) {

    }
    @Override
    public void agregarUnidadADistancia(List<Unidad> unidadesADistanciaCercana) {

    }
    @Override
    public Posicion calcularPosicionCercana(Direccion direccionActual, int counter) {
        return posicion;
    }

    @Override
    public void seEncuentraViva(ArrayList<Unidad> unidadesDisponibles, Casillero casilleroUnidad) {

    }
}
