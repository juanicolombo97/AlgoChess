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

    public Jinete( Puntos puntosJugador, Posicion posicion) throws NoAlcanzanLosPuntosException {
        puntosJugador.puntosSuficientes(costoUnidad);
        this.posicion = posicion;
    //TODO: cuando se instancia un jinete validar sus unidades cercanas para ver si se cambia su estado
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
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        estadoJinete.atacarDistanciaCerca(atacado);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadNulaException, UnidadInvalidaException {
        if (esUnidadAliada){
            throw new UnidadInvalidaException("La unidad que quieres atacar es aliada");
        }
        estadoJinete.atacarDistanciaMediana(atacado);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean esUnidadAliada, HashMap tablero) throws NoPuedeAtacarException, UnidadInvalidaException {
        estadoJinete.atacarDistanciaLejana(atacado);
    }

    @Override
    public void recibirDanio(double danioRecibido) {
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
    public ArrayList habilidadMoverse(Unidad unidadAMover, HashMap tablero, ArrayList unidadesAliadas) throws MovimientoInvalidoException {
        ArrayList listaUnidadesAMover = new ArrayList();
        listaUnidadesAMover.add(this);
        return listaUnidadesAMover;
    }

    public void recibirNotificacion() {
        if (emisario.cantidadSoldadosAliadosCercanos(this) == 0 && emisario.unidadesEnemigasCercanas(this).size() > 0){
            setEstadoJinete("espadachin");
        } else if (emisario.cantidadSoldadosAliadosCercanos(this) > 0 || emisario.unidadesEnemigasCercanas(this).size() == 0)
            setEstadoJinete("arquero");

    }

    public EstadoJinete getEstado(){
        return estadoJinete;
    }

}
