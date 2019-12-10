package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.*;

import java.util.concurrent.atomic.AtomicInteger;

public class Casillero{

    private final Posicion posicionCasillero;
    private EstadoCasillero estadoCasillero;


    public Casillero(Posicion posicion){
        this.posicionCasillero = posicion;
        estadoCasillero = new EstadoCasilleroVacio();
    }

    public void guardarUnidad(Unidad unidadNueva) {
        estadoCasillero = estadoCasillero.guardarUnidad(unidadNueva);
        unidadNueva.modificarPosicion(posicionCasillero);

   }
   public void eliminarUnidad() {
        estadoCasillero = estadoCasillero.eliminarUnidad();
   }

   public Unidad obtenerUnidad() {
        return estadoCasillero.obtenerUnidad();
   }

   public Posicion getPosicionCasillero(){
        return posicionCasillero;
   }

   public void validarMovimiento(Casillero casilleroDestino) {
        casilleroDestino.validarDistancia(this.posicionCasillero);
   }

   public void validarDistancia(Posicion posicion) {
        posicionCasillero.distanciaValidaDesde(posicion);
   }

   public Distancia calcularDistancia(Posicion posicionAtacado){
       return this.posicionCasillero.calcularDistancia(posicionAtacado);
   }

   public Unidad obtenerUnidadCercana(){
        return estadoCasillero.obtenerUnidadCercana();
   }

    public void guardarUnidadCercana(Unidad unidad, Jugador jugador, Casillero casilleroInicio, AtomicInteger contador) {
        estadoCasillero.guardarUnidadCercana(unidad,jugador,casilleroInicio,contador,this);
    }

    public void modificarEstadoCasillero(EstadoCasillero estadoCasilleroNuevo){
        this.estadoCasillero = estadoCasilleroNuevo;
    }
}