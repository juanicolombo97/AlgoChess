import excepciones.CurarCatapultaException;
import excepciones.NoPuedeAtacarException;

public class Soldado implements Unidades {
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;

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
        return danioCuerpo;
    }

    @Override
    public int getDanioDist() throws NoPuedeAtacarException{
        throw new NoPuedeAtacarException("El soldado solo ataca cuerpo a cuerpo");
    }

    @Override
    public void atacado(int danio) {
        vidaUnidad -= danio;
    }

    public void curar(int curacion) throws CurarCatapultaException {
        vidaUnidad += curacion;
    }
}


