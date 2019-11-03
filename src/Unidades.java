import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
// Interfaz que representa las unidades del juego.

public interface Unidades {
    // Interfaz de las unidades del juego.

    public int getCosto();

    public int getVida();

    public int getDanio() throws NoPuedeAtacarException;

    public int getDanioDist() throws NoPuedeAtacarException;

    public void recibirDanio(int danio);

    public void curarse(int curacion) throws CurarCatapultaException;

    public void atacarCuerpo(Unidades atacado) throws NoPuedeAtacarException;

    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException;
}
