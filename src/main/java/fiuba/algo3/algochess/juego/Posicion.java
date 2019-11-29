package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;

import java.util.Objects;

public class Posicion {

    private int posicionX, posicionY;


    public Posicion(int posicionX, int posicionY){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }


    public Distancia distanciaValidaDesde(Posicion posicion) throws MovimientoInvalidoException {
        Distancia distancia = posicion.distanciaValidaHasta(this.posicionX,this.posicionY);
        return distancia;
    }

    private Distancia distanciaValidaHasta(int posicionX, int posicionY) throws MovimientoInvalidoException {
        int distanciaX = Math.abs(this.posicionX - posicionX);
        int distanciaY = Math.abs(this.posicionY - posicionY);
        if (distanciaX > 1 && distanciaY > 1){
            throw new MovimientoInvalidoException("Solo se mueve de a 1 casillero");
        }
        return new Distancia(distanciaX,distanciaY);
    }

   public int getPosicionX(){
        return posicionX;
    }

    public int getPosicionY(){
        return posicionY;
    }

    public Distancia calcularDistancia(Posicion posicionFinal){
        return posicionFinal.calcularDistancia(this.posicionX,this.posicionY);
    }

    public Distancia calcularDistancia(int posicionX, int posicionY){
        int distanciaX = Math.abs(this.posicionX - posicionX);
        int distanciaY = Math.abs(this.posicionY - posicionY);
        return new Distancia(distanciaX,distanciaY);
    }

    public Posicion posicionNueva(Direccion direccion){
        return direccion.posicionNueva(posicionX,posicionY);
    }

    public Posicion posicionNuevaPorDistancia(Distancia distancia){ return distancia.posicionNueva(posicionX, posicionY);}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return posicionX == posicion.posicionX &&
                posicionY == posicion.posicionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionX, posicionY);
    }
}
