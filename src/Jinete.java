import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class Jinete implements Unidad {
    private static int costoUnidad = 3;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 5;
    private static int danioDistancia = 15;
    private Posicion posicion = new Posicion();

    public Jinete(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public int getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioDistancia);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete no puede atacar distancias lejanas");
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
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.movimientoNuevo(posicionNuevaX,posicionNuevaY);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}
