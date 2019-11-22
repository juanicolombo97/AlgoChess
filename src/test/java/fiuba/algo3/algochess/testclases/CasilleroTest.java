package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.UnidadNula;
import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {
    @Test
    public void casilleroEstaVacioAlSerCreado(){
        Casillero casillero = new Casillero(1,1);
        Assert.assertEquals(casillero.getUnidad().getClass(), UnidadNula.class);
    }

    @Test
    public void guardarUnidad() throws CasilleroOcupadoException {
        Casillero casillero = new Casillero(1,2);
        Soldado soldado = new Soldado(1, 2);
        casillero.guardarUnidad(soldado);
        Assert.assertEquals(soldado, casillero.getUnidad());
    }

    @Test
    public void eliminarUnidad() throws CasilleroOcupadoException, UnidadNulaException, MovimientoInvalidoException {
        Casillero casillero = new Casillero(1,2);
        Casillero casilleroDestino = new Casillero(1,3);
        Soldado soldado1 = new Soldado(1,2);
        casillero.guardarUnidad(soldado1);
        casillero.moverUnidad(casilleroDestino);
        Assert.assertEquals(UnidadNula.class, casillero.getUnidad().getClass());
    }
}