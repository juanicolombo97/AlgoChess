package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.CurarException;

public class Curandero implements Unidad {
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;
    private int posicionX, posicionY;

    public Curandero(int posicionX,int posicionY){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getVidaUnidad(){
        return vidaUnidad;
    }
    @Override
    public boolean estaVivo() {
        return vidaUnidad >= 0;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException {
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException,CurarException{
        throw new NoPuedeAtacarException("El curandero solo puede atacar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws CurarException, NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero solo puede atacar a distancia cercana");
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        vidaUnidad -= danioRecibido;
    }

    @Override
    public int cuantoCuesta() {
        return costoUnidad;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException {
        vidaUnidad += vidaACurar;
    }

    @Override
    public int posicionEnX(){
        return posicionX;
    }

    @Override
    public int posicionEnY(){
        return posicionY;
    }

    @Override
    public String getNombre() {
        return "curandero";
    }
    @Override
    public void nuevaPosicion(int posx, int posy) {
        this.posicionX = posx;
        this.posicionY = posy;
    }


}
