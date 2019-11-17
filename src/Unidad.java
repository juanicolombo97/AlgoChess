import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException;

    public void recibirDanio(int danioRecibido) throws UnidadNulaException;

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException, UnidadNulaException;

    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException;

    public Posicion getPosicion();
}
