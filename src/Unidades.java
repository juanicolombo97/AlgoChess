import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
// Interfaz que representa las unidades del juego.

public interface Unidades {
    // Interfaz de las unidades del juego.

    public int getCosto();

    public int getVida();

    public int getDanio() throws NoPuedeAtacarException;

    public int getDanioDist() throws NoPuedeAtacarException;

    public void atacado(int danio);

    public void curar(int curacion) throws CurarCatapultaException;
}
