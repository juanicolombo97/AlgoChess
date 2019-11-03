import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Catapulta implements Unidades {
    private static int costoUnidad = 5;
    private int vidaUnidad = 50;
    private static int danioDistancia = 20;

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
       throw new NoPuedeAtacarException("La catapulta no puede atacar cuerpo a cuerpo");
    }

    @Override
    public int getDanioDist() throws NoPuedeAtacarException {
        return danioDistancia;
    }

    @Override
    public void recibirDanio(int danio) {
        vidaUnidad-= danio;
    }

    @Override
    public void curarse(int curacion) throws CurarCatapultaException {
        throw new CurarCatapultaException("No se puede curar a una catapulta");
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