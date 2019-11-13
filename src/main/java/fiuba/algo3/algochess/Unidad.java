package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
// Interfaz que representa las unidades del juego.

public interface Unidad {

    public boolean estaVivo();

    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException;

    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, CurarException;

    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException, CurarException;

    public void recibirDanio(int danioRecibido);

    public int cuantoCuesta();

    public void curarse(int vidaACurar) throws CurarException;

    public int posicionEnX();

    public int posicionEnY();

    public String getNombre();

    public void nuevaPosicion(int posx, int posy);

}
