package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.*;

public class Casillero{

    private final Posicion posicionCasillero;
    private EstadoCasillero estadoCasillero;
    private Jugador jugador;

    public Casillero(Posicion posicion,Jugador jugador){
        this.posicionCasillero = posicion;
        estadoCasillero = new EstadoCasilleroVacio();
        this.jugador = jugador;
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

   public void movimientoValido(Casillero casilleroDestino) {
        casilleroDestino.distanciaCorrecta(this.posicionCasillero);
   }

   public void distanciaCorrecta(Posicion posicion) {
        posicionCasillero.distanciaValidaDesde(posicion);
   }

   public Distancia calcularDistancia(Posicion posicionAtacado){
       return this.posicionCasillero.calcularDistancia(posicionAtacado);
   }
   public Unidad obtenerUnidadCercana(){
        return estadoCasillero.obtenerUnidadCercana();
   }


}