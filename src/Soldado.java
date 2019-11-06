import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Soldado implements Unidades{
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;


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
        throw new NoPuedeAtacarException("El soldado no puede atacar a distancia");
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


