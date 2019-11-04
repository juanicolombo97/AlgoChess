import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Soldado implements Unidades{
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;

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
        // Devuelve el danio a corta distancia de la unidad.
    public int getDanio() throws NoPuedeAtacarException {
        return danioCuerpo;
    }
    @Override
        // Genera un error ya que el soldado no puede atacar a distancia.
    public int getDanioDist() throws NoPuedeAtacarException{
        throw new NoPuedeAtacarException("El soldado solo ataca cuerpo a cuerpo");
    }

    @Override
        // Modifica la vida de la unidad cuando es atacado.
    public void recibirDanio(int danio) {
        vidaUnidad -= danio;
    }

    @Override
        // Se cura la vida por una cantidad recibida por parametro.
    public void curarse(int curacion) throws CurarCatapultaException {
        vidaUnidad += curacion;
    }

    @Override
        // Ataca a una unidad recibida a corta distancia.
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


