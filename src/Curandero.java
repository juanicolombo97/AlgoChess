import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Curandero implements Unidades {
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;


    @Override
    public boolean estaVivo() {
        return vidaUnidad != 0;
    }

    @Override
    public void atacar(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar");
    }

    @Override
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar");
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

    public void curar(Unidades unidadACurar) throws CurarCatapultaException {
        unidadACurar.curarse(curacion);
    }
}
