package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.UnidadNula;
import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {
    @Test
    public void casilleroEstaVacioAlSerCreado(){
        Casillero casillero = new Casillero();
        Assert.assertEquals(casillero.getUnidad().getClass(), UnidadNula.class);
    }

    @Test
    public void guardarUnidad() {
        Casillero casillero = new Casillero();
        Soldado soldado = new Soldado(1, 2);
        casillero.guardarUnidad(soldado);
        Assert.assertEquals(soldado, casillero.getUnidad());
    }

    @Test
    public void modificarUnidadLanzaExcepcionAlEstarVacio(){
        Casillero casillero = new Casillero();
        Soldado soldado = new Soldado(3, 4);
        try{
            casillero.modificarUnidad(soldado);
        } catch (CasilleroOcupadoException e){

        }
    }

    @Test
    public void eliminarUnidad(){
        Casillero casillero = new Casillero();
        Soldado soldado1 = new Soldado(1,2);
        casillero.guardarUnidad(soldado1);
        casillero.eliminarUnidad();
        Assert.assertEquals(UnidadNula.class, casillero.getUnidad().getClass());
    }
}