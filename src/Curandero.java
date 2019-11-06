import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class Curandero implements Unidades {
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
        return vidaUnidad != 0;
    }

    @Override
    public void atacarDistanciaCerca(Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidades atacado) throws NoPuedeAtacarException,CurarException{
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidades atacado) throws CurarException, NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
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
}
