import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class Jinete implements Unidad {
    private static int costoUnidad = 3;
    private double vidaUnidad = 100;
    private static double danioCuerpo = 5;
    private static double danioDistancia = 15;
    private Posicion posicion = new Posicion();

    public Jinete(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioCuerpo + (danioExtra * danioCuerpo));
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioDistancia + (danioExtra * danioDistancia));
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete no puede atacar distancias lejanas");
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
        vidaUnidad += vidaACurar;
    }

    @Override
    public void moverUnidad(Direccion direccion) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.movimientoNuevo(direccion);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}
