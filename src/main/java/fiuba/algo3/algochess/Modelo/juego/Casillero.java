package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.unidades.*;

public class Casillero{

    private final Posicion posicionCasillero;
    private EstadoCasillero estadoCasillero;
    public boolean casilleroAliado;

    public Casillero(Posicion posicion,boolean casilleroAliado){
        this.posicionCasillero = posicion;
        estadoCasillero = new EstadoCasilleroVacio();
        this.casilleroAliado = casilleroAliado;
    }

    public void guardarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException {
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

}