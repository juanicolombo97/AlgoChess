package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;

public class Posicion {

    private int posicionX, posicionY;

    public void posicionNueva(int posicionX, int posicionY){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void movimientoHacia(Direccion direccion) throws MovimientoInvalidoException {
        this.posicionX = this.posicionX + posicionX;
        this.posicionY = this.posicionY + posicionY;
    }

    public int distanciaXHasta(Posicion posicion){
        return (Math.abs(this.posicionX - posicion.getPosicionX()));
    }

    public int distanciaYHasta(Posicion posicion){
        return (Math.abs(this.posicionY - posicion.getPosicionY()));
    }

   /* creo que tener estos métodos rompe el encapsulamiento que se trata de tener con
   esta clase */

    public int getPosicionX(){
        return posicionX;
    }
    public int getPosicionY(){
        return posicionY;
    }

}