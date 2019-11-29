package fiuba.algo3.algochess.juego;

public class Distancia {

    private int distanciaX,distanciaY;

    public Distancia(int distanciaX,int distanciaY){
        this.distanciaX = distanciaX;
        this.distanciaY = distanciaY;
    }

    public Posicion posicionNueva(int posicionX, int posicionY){
        return new Posicion(posicionX + distanciaX, posicionY + distanciaY);
    }

    public int getDistanciaX(){
        return this.distanciaX;
    }

    public int getDistanciaY() {
        return this.distanciaY;
    }
}
