package fiuba.algo3.algochess;
import java.lang.Math;

public class Posicion {
    private int x;
    private int y;

    public int calcularDistanciaHasta(Posicion posicion){
        int distancia = posicion.calcularDistanciaDesde(this.x, this.y);
        return distancia;
    }
    public int calcularDistanciaDesde(int otherX, int otherY){
        int distanciaX = Math.abs(otherX - this.x);
        int distanciaY = Math.abs(otherY - this.y);
        return (distanciaX + distanciaY);
    }

}
