import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class UnidadNula implements Unidad {

    private Posicion posicion = new Posicion();

    public UnidadNula(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void recibirDanio(int danioRecibido) throws UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public int cuantoCuesta() {
        return 0;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException {
        throw new UnidadNulaException("No se encuentra una unidad");
    }

    @Override
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException {
        throw new UnidadNulaException("Unidad invalida");
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}
