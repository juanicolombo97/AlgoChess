package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CasilleroTest {
    @Test
    public void casilleroEstaVacioAlSerCreado(){
        Posicion posicionNueva = new Posicion(1,1);
        Casillero casillero = new Casillero(posicionNueva);
        try {
            casillero.obtenerUnidad();
        } catch (CasilleroVacioExcepcion e) {
            Assertions.assertEquals("El casillero esta vacio",e.getMessage());
        }

    }

    @Test
    public void guardarUnidad() throws CasilleroOcupadoException {
        Casillero casillero = new Casillero(true,1,2);
        Soldado soldado = new Soldado(1, 2, new EmisarioNulo());
        casillero.guardarUnidad(soldado);
        Assert.assertEquals(soldado, casillero.getUnidad());
    }

    @Test
    public void guardarUnidadCasilleroOcupadoError() throws CasilleroOcupadoException {
        Casillero casillero = new Casillero(true,1,1);
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