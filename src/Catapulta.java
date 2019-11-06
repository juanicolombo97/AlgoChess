import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

//Clase donde se implementa la Unidad Catapulta

public class Catapulta implements Unidades {
    private static int costoUnidad = 5;
    private int vidaUnidad = 50;
    private static int danioDistancia = 20;


    @Override
    public boolean estaVivo() {
        return vidaUnidad != 0;
    }

    @Override
    public void atacar(Unidades atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca de lejos");
    }

    @Override
    public void atacarDistancia(Unidades atacado) {
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
        throw new CurarCatapultaException("La catapulta no puede ser curada");
    }

}