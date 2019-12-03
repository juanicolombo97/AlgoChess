package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.AjustaDanio;
import fiuba.algo3.algochess.Modelo.juego.AjustaDanioActivo;
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
    private AjustaDanio ajustaDanio;

    public Jinete( Puntos puntosJugador, Posicion posicion, Emisario emisario) throws NoAlcanzanLosPuntosException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        this.posicion = posicion;
        this.emisario = emisario;
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
    public void modificarPosicion(Posicion posicion) throws MovimientoInvalidoException, CasilleroVacioExcepcion {
        this.posicion = posicion;
        this.emisario.notificar(this);
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
        vidaUnidad -= ajustaDanio.ajustarDanio(danioRecibido, this);
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

    @Override
    public void recibirNotificacion() throws CasilleroVacioExcepcion {
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
    public void recibirAjustaDanio(AjustaDanio ajustaDanio){
        this.ajustaDanio = ajustaDanio;
    }

}
