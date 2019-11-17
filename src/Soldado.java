import Excepciones.CurarException;
import Excepciones.MovimientoInvalidoException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;
import javafx.geometry.Pos;

public class Soldado implements Unidad {
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;
    private Posicion posicion = new Posicion();

    public Soldado(int posicionX,int posicionY){
        posicion.posicionNueva(posicionX,posicionY);
    }

    public int getVidaUnidad(){
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
    public void recibirDanio(int danioRecibido) {
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

}


