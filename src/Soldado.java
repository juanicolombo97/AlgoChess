import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class Soldado implements Unidad {
    private static int costoUnidad = 1;
    private double vidaUnidad = 100;
    private static double danioCuerpo = 10;
    private Posicion posicion = new Posicion();

    public Soldado(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }


    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danioCuerpo);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El soldado solo ataca distancia cercana");
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
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.movimientoNuevo(posicionNuevaX,posicionNuevaY);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

}


