package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.unidades.*;

public class Casillero{

    private final Posicion posicionCasillero;
    private EstadoCasillero estadoCasillero;
    private Jugador jugador;
    private boolean casilleroAliado;

    public Casillero(Posicion posicion, Jugador jugador, boolean casilleroAliado){
        this.posicionCasillero = posicion;
        estadoCasillero = new EstadoCasilleroVacio();
        this.jugador = jugador;
        this.casilleroAliado = casilleroAliado;
    }

    public void guardarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        estadoCasillero = estadoCasillero.guardarUnidad(unidadNueva);
        unidadNueva.modificarPosicion(posicionCasillero);
   }
   public void eliminarUnidad() throws CasilleroVacioExcepcion {
        estadoCasillero = estadoCasillero.eliminarUnidad();
   }

   public Unidad obtenerUnidad() throws CasilleroVacioExcepcion {
        return estadoCasillero.obtenerUnidad();
   }
   public Posicion getPosicionCasillero(){
        return posicionCasillero;
   }

   public void movimientoValido(Casillero casilleroDestino) throws MovimientoInvalidoException {
        casilleroDestino.distanciaCorrecta(this.posicionCasillero);
   }

   public void distanciaCorrecta(Posicion posicion) throws MovimientoInvalidoException {
        posicionCasillero.distanciaValidaDesde(posicion);
   }

   public Distancia calcularDistancia(Posicion posicionAtacado){
       return this.posicionCasillero.calcularDistancia(posicionAtacado);
   }

   public boolean casilleroAliadoAJugador(Jugador jugador){
        return this.jugador == jugador;
   }

   public boolean atacadoEstaEnCasilleroEnemigo(Jugador jugador, Unidad atacado){
        return !jugador.unidadAliada(atacado) && this.casilleroAliadoAJugador(jugador);
   }

   public boolean esCasilleroAliado(){
        return this.casilleroAliado;
   }

}