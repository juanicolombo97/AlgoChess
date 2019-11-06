import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

//Clase donde se implementa la Unidad Catapulta

public class Catapulta implements Unidades {
    private static int costoUnidad = 5;
    private int vidaUnidad = 50;
    private static int danioDistancia = 20;
    private int posicionX, posicionY;

    public Catapulta(int posicionX,int posicionY){
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
    public void atacarDistanciaCerca(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaMediana(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaLejana(Unidades atacado) throws NoPuedeAtacarException {
        atacado.recibirDanio(danioDistancia);
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
        throw new CurarException("La catapulta no puede ser curada");
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