package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;

public class UnidadNull implements Unidad {

    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, CurarException {
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, CurarException {
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException, CurarException {
    }

    @Override
    public void recibirDanio(int danioRecibido) {
    }

    @Override
    public int cuantoCuesta() {
        return 0;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException {
    }

    @Override
    public int posicionEnX() {
        return 0;
    }

    @Override
    public int posicionEnY() {
        return 0;
    }

    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public void nuevaPosicion(int posx, int posy) {
    }
}
