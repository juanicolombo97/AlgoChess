package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;

import java.net.PortUnreachableException;
import java.util.Objects;

public class Posicion {

    public int posicionX, posicionY;


    public Posicion(int posicionX, int posicionY){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }


    public Distancia distanciaValidaDesde(Posicion posicion) {
        Distancia distancia = posicion.distanciaValidaHasta(this.posicionX,this.posicionY);
        return distancia;
    }

    private Distancia distanciaValidaHasta(int posicionX, int posicionY) {
        int distanciaX = Math.abs(this.posicionX - posicionX);
        int distanciaY = Math.abs(this.posicionY - posicionY);
        if (distanciaX > 1 && distanciaY > 1){
            throw new MovimientoInvalidoException("Solo se mueve de a 1 casillero");
        }
        return new Distancia(distanciaX,distanciaY);
    }



    public Distancia calcularDistancia(Posicion posicionFinal){
        return posicionFinal.calcularDistancia(this.posicionX,this.posicionY);
    }

    public Distancia calcularDistancia(int posicionX, int posicionY){
        int distanciaX = Math.abs(this.posicionX - posicionX);
        int distanciaY = Math.abs(this.posicionY - posicionY);
        return new Distancia(distanciaX,distanciaY);
    }

    public Distancia calcularDistanciaConDireccion(Posicion posicionFinal){
        return posicionFinal.calcularDistanciaConDireccion(this.posicionX,this.posicionY);
    }

    public Distancia calcularDistanciaConDireccion(int posicionX, int posicionY){
        int distanciaX = this.posicionX - posicionX;
        int distanciaY = this.posicionY - posicionY;
        return new Distancia(distanciaX,distanciaY);
    }

    public Posicion posicionNueva(Direccion direccion){
        return direccion.posicionNueva(posicionX,posicionY);
    }

    public Posicion posicionValida(){
        if (posicionX > 0 && posicionY > 0){
            return this;
        }
        throw new MovimientoInvalidoException("La posicion es invalida");
    }
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
