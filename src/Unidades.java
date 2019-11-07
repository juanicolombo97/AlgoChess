import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
// Interfaz que representa las unidades del juego.

public interface Unidades {

    public boolean estaVivo();

    public void atacarDistanciaCerca(Unidades atacado) throws NoPuedeAtacarException, CurarException;

    public void atacarDistanciaMediana(Unidades atacado) throws NoPuedeAtacarException, CurarException;

    public void atacarDistanciaLejana(Unidades atacado) throws NoPuedeAtacarException, CurarException;

    public void recibirDanio(int danioRecibido);

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException;

    public int posicionEnX();

    public int posicionEnY();

    public String getNombre();

    public void nuevaPosicion(int posx, int posy);

}
