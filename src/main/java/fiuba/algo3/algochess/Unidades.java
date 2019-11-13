package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
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
