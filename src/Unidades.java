import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
// Interfaz que representa las unidades del juego.

public interface Unidades {

    public boolean estaVivo();

    public void atacar(Unidades atacado) throws NoPuedeAtacarException;

    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException;

    public void recibirDanio(int danioRecibido);

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarCatapultaException;
}
