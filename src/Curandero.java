import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class Curandero implements Unidad {
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;
    private Posicion posicion = new Posicion();

    public Curandero(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public int getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacado.curarse(curacion);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException,CurarException{
        throw new NoPuedeAtacarException("El curandero solo puede curar a distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws CurarException, NoPuedeAtacarException {
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
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.movimientoNuevo(posicionNuevaX,posicionNuevaY);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}
