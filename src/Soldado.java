import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class Soldado implements Unidades{
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;
    private int posicionX, posicionY;

    public Soldado(int posicionX,int posicionY){
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
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
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
        return "soldado";
    }
}


