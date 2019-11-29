package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasilleroTest {

    @Test
    public void seCrearCasilleroVacioCorrectamente(){
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,true);
        try {
            casillero.obtenerUnidad();
        } catch (CasilleroVacioExcepcion e) {
            Assertions.assertEquals("El casillero esta vacio",e.getMessage());
        }
    }
    @Test
    public void seCreaCasilleroYSeAgregaUnidadCorrectamente() throws NoAlcanzanLosPuntosException, CasilleroOcupadoException, CasilleroVacioExcepcion {
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,true);
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion);
        casillero.guardarUnidad(soldado);
        Soldado soldado2 = (Soldado) casillero.obtenerUnidad();
        Assertions.assertEquals(soldado.getPosicion(),soldado2.getPosicion());
    }
    @Test
    public void seQuiereAgregarUnidadACasilleroOcupado() throws NoAlcanzanLosPuntosException, CasilleroOcupadoException {
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Casillero casillero = new Casillero(posicion,true);
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        casillero.guardarUnidad(soldado);
        try {
            casillero.guardarUnidad(soldado1);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }
    @Test
    public void eliminarUnidadDeCasilleroFuncionaCorrectamente() throws NoAlcanzanLosPuntosException, CasilleroOcupadoException, CasilleroVacioExcepcion {
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,true);

        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion);
        casillero.guardarUnidad(soldado);
        casillero.eliminarUnidad();
        try {
            casillero.obtenerUnidad();
        }catch (CasilleroVacioExcepcion e){
            Assertions.assertEquals("El casillero esta vacio",e.getMessage());
        }

    }
}
