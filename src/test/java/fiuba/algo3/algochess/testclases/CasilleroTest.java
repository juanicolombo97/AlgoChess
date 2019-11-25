package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.EmisarioNulo;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.UnidadNula;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CasilleroTest {
    @Test
    public void casilleroEstaVacioAlSerCreado(){
        Casillero casillero = new Casillero(1,1);
        Assert.assertEquals(casillero.getUnidad().getClass(), UnidadNula.class);
    }

    @Test
    public void guardarUnidad() throws CasilleroOcupadoException {
        Casillero casillero = new Casillero(1,2);
        Soldado soldado = new Soldado(1, 2, new EmisarioNulo());
        casillero.guardarUnidad(soldado);
        Assert.assertEquals(soldado, casillero.getUnidad());
    }

    @Test
    public void guardarUnidadCasilleroOcupadoError() throws CasilleroOcupadoException {
        Casillero casillero = new Casillero(1,1);
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        Soldado soldado2 = new Soldado(2,2, new EmisarioNulo());
        casillero.guardarUnidad(soldado);

        try {
            casillero.guardarUnidad(soldado2);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero esta ocupado",e.getMessage());
        }
    }

}