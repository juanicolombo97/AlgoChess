import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

//Clase donde se implementa la Unidad Catapulta

public class Catapulta implements Unidades {
    private static int costoUnidad = 5;
    private int vidaUnidad = 50;
    private static int danioDistancia = 20;

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
        // Genera un error ya que la Catapulta no tiene danio a corta distancia.
    public int getDanio() throws NoPuedeAtacarException {
       throw new NoPuedeAtacarException("La catapulta no puede atacar cuerpo a cuerpo");
    }
    @Override
        // Devuelve el danio a distancia de la catapulta.
    public int getDanioDist() throws NoPuedeAtacarException {
        return danioDistancia;
    }
    @Override
        // Funcin que modifica la vida de la unidad al ser atacada.
    public void recibirDanio(int danio) {
        vidaUnidad-= danio;
    }

    @Override
        // Devuelve un Error ya que la catapulta no se puede curar.
    public void curarse(int curacion) throws CurarCatapultaException {
        throw new CurarCatapultaException("No se puede curar a una catapulta");
    }
    @Override
        // Funcion que recibe una unidad a atacar a corta distancia.
    public void atacarCuerpo(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanio());
    }
    @Override
        // Funcion que recibe una unidad a atacar a larga distancia.
    public void atacarDistancia(Unidades atacado) throws NoPuedeAtacarException{
        atacado.recibirDanio(this.getDanioDist());
    }
    @Override
        // Funcion que devuelve true si la unidad esta viva y false en caso contrario.
    public boolean estaVivo(){
        return vidaUnidad > 0;
    }
}