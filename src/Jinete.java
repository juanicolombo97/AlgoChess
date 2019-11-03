import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Jinete implements Unidades {
    private static int costoUnidad = 3;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 5;
    private static int danioDistancia = 15;


    @Override
        // Devuelve el costo de la unidad.
    public int getCosto() {
        return costoUnidad;
    }

    @Override
        // Devuelve la vida de la unidad.
    public int getVida() {
        return vidaUnidad;
    }

    @Override
        // Devuelve el danio de la unidad.
    public int getDanio() throws NoPuedeAtacarException {
        return danioCuerpo;
    }

    @Override
        // Devuelve el danio de la unidad a distancia.
    public int getDanioDist() throws NoPuedeAtacarException {
        return danioDistancia;
    }

    @Override
        // Modifica la vida de la unidad al ser atacada.
    public void recibirDanio(int danio) {
        vidaUnidad -= danio;
    }

    @Override
        // Cura a la unidad por una cantidad recibida por parametro.
    public void curarse(int curacion) throws CurarCatapultaException{
        vidaUnidad += curacion;
    }
    @Override
        // Ataca a una unidad a corta distancia
    public void atacarCuerpo(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanio());
    }

    @Override
        // Ataca a una unidad a larga distancia.
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanioDist());
    }
    @Override
    // Funcion que devuelve true si la unidad esta viva y false en caso contrario.
    public boolean estaVivo(){
        return vidaUnidad > 0;
    }

}
