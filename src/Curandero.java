import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Curandero implements Unidades {
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;


    @Override
    public int getCosto() {
        return costoUnidad;
    }

    @Override
    public int getVida() {
        return vidaUnidad;
    }

    @Override
    public int getDanio() throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar.");
    }
    @Override
    public int getDanioDist() throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar.");
    }

    @Override
    public void atacado(int danio) {
        vidaUnidad -= danio;
    }

    public int getCuracion(){
        return curacion;
    }

    @Override
    public void curar(int curacion) throws CurarCatapultaException {
        vidaUnidad+= curacion;
    }
}
