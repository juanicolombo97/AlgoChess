import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

//Clase donde se implementa la Unidad Catapulta

public class Catapulta implements Unidad {
    private static int costoUnidad = 5;
    private double vidaUnidad = 50;
    private static double danioDistancia = 20;
    private Posicion posicion = new Posicion();

    public Catapulta(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioDistancia + (danioExtra * danioDistancia));
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        vidaUnidad -= danioRecibido;
    }

    @Override
    public int cuantoCuesta() {
        return costoUnidad;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException {
        throw new CurarException("La catapulta no puede ser curada");
    }
    @Override
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
       throw new MovimientoInvalidoException("La catapulta no se puede mover");
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}