package fiuba.algo3.algochess.Modelo.juego;

public class Distancia {

    private int distanciaX,distanciaY;

    public Distancia(int distanciaX,int distanciaY){
        this.distanciaX = distanciaX;
        this.distanciaY = distanciaY;
    }


    public int getDistanciaX(){
        return this.distanciaX;
    }

    public int getDistanciaY() {
        return this.distanciaY;
    }
}
