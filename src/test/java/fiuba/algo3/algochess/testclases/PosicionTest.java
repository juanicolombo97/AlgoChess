package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
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
    public void movimientoNuevo() throws MovimientoInvalidoException {
        Posicion posicion = new Posicion();
        posicion.posicionNueva(2, 2);
        posicion.movimientoNuevo(1, -1);
        Assert.assertEquals(3, posicion.getPosicionX());
        Assert.assertEquals(1, posicion.getPosicionY());
    }

    @Test
    public void movimientoInvalidoAlMoverseMasDeUnCasillero() throws MovimientoInvalidoException {
        Posicion posicion = new Posicion();
        posicion.posicionNueva(2, 2);
        try {
            posicion.movimientoNuevo(2, -1);
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