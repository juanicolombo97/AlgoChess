import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Curandero implements Unidades {
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;


    @Override
        //Devuelve el costo de la unidad.
    public int getCosto() {
        return costoUnidad;
    }

    @Override
        // Devuelve la vida de la unidad.
    public int getVida() {
        return vidaUnidad;
    }

    @Override
        // Devuelve Error ya que el curandero no puede atacar.
    public int getDanio() throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar.");
    }
    @Override
        //Devuelve Error ya que el curandero no puede atacar.
    public int getDanioDist() throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El curandero no puede atacar.");
    }
    @Override
        // Modifica la vida del curandero cuando es atacado.
    public void recibirDanio(int danio) {
        vidaUnidad -= danio;
    }

        // Devuelve la curacion que otorga el curandero.
    public int getCuracion(){
        return curacion;
    }

    @Override
        // Funcion que recibe la cantidad de vida a curarse la unidad.
    public void curarse(int curacion) throws CurarCatapultaException {
        vidaUnidad+= curacion;
    }
        // Funcion que recibe una unidad a curar.
    public void curar(Unidades unidadACurar) throws CurarCatapultaException{
        unidadACurar.curarse(this.getCuracion());
    }

    @Override
        // Funcion que recibe una unidad a ser atacada a corta distancia.
    public void atacarCuerpo(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanio());
    }

    @Override
        // Funcion que recibe una unidad a ser atacada a larga distancia.
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanioDist());
    }
    @Override
    // Funcion que devuelve true si la unidad esta viva y false en caso contrario.
    public boolean estaVivo(){
        return vidaUnidad > 0;
    }
}
