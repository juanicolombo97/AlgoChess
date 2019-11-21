package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Direccion;
import fiuba.algo3.algochess.juego.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {

    @Test
    public void posicionNueva() {
        Posicion posicion = new Posicion();
        posicion.posicionNueva(5, 3);
        Assert.assertEquals(5, posicion.getPosicionX());
        Assert.assertEquals(3, posicion.getPosicionY());
    }

    @Test
    public void movimientoHacia() throws MovimientoInvalidoException {
        Posicion posicion = new Posicion();
        posicion.posicionNueva(2, 2);
        Direccion direccion = new Direccion(1, -1);
        try {
            posicion.movimientoHacia(direccion);
        }
        catch (MovimientoInvalidoException e){

        }
    }

    @Test
    public void movimientoInvalidoAlMoverseMasDeUnCasillero() throws MovimientoInvalidoException {
        Posicion posicion = new Posicion();
        posicion.posicionNueva(2, 2);
        Direccion direccion = new Direccion(2, -1);
        try {
            posicion.movimientoHacia(direccion);
        } catch (MovimientoInvalidoException e) {
        }
    }

    @Test
    public void distanciaXHasta() {
        Posicion posicion0101 = new Posicion();
        posicion0101.posicionNueva(1, 1);
        Posicion posicion0305 = new Posicion();
        posicion0305.posicionNueva(3, 5);
        Assert.assertEquals(2, posicion0101.distanciaXHasta(posicion0305));
        Assert.assertEquals(2, posicion0305.distanciaXHasta(posicion0101));
    }

    @Test
    public void distanciaYHasta() {
        Posicion posicion0101 = new Posicion();
        posicion0101.posicionNueva(1, 1);
        Posicion posicion0305 = new Posicion();
        posicion0305.posicionNueva(3, 5);
        Assert.assertEquals(4, posicion0101.distanciaYHasta(posicion0305));
        Assert.assertEquals(4, posicion0305.distanciaYHasta(posicion0101));
    }
}