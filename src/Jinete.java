import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Jinete implements Unidades {
    private static int costoUnidad = 3;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 5;
    private static int danioDistancia = 15;


    @Override
    public boolean estaVivo() {
        return vidaUnidad != 0;
    }

    @Override
    public void atacar(Unidades atacado) throws NoPuedeAtacarException {
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException {
        atacado.recibirDanio(danioDistancia);
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
    public void curarse(int vidaACurar) throws CurarCatapultaException {
        vidaUnidad += vidaACurar;
    }
}
