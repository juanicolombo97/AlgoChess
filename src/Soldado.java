import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

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
    public void recibirDanio(int danio) {
        vidaUnidad -= danio;
    }

    @Override
    public void curarse(int curacion) throws CurarCatapultaException {
        vidaUnidad += curacion;
    }

    @Override
    public void atacarCuerpo(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanio());
    }

    @Override
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanioDist());
    }
}


