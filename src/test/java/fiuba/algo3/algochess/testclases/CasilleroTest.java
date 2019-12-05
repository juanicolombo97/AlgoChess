package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.juego.*;
import fiuba.algo3.algochess.Modelo.unidades.EmisarioNulo;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasilleroTest {

    @Test
    public void seCrearCasilleroVacioCorrectamente(){
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion, new JugadorNulo());
        try {
            casillero.obtenerUnidad();
        } catch (CasilleroVacioExcepcion e) {
            Assertions.assertEquals("El casillero esta vacio",e.getMessage());
        }
    }
    @Test
    public void seCreaCasilleroYSeAgregaUnidadCorrectamente() {
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion, new JugadorNulo());
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        casillero.guardarUnidad(soldado);
        Soldado soldado2 = (Soldado) casillero.obtenerUnidad();
        Assertions.assertEquals(soldado.getPosicion(),soldado2.getPosicion());
    }
    @Test
    public void seQuiereAgregarUnidadACasilleroOcupado() {
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Casillero casillero = new Casillero(posicion, new JugadorNulo());
        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion1, new EmisarioNulo());
        casillero.guardarUnidad(soldado);
        try {
            casillero.guardarUnidad(soldado1);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }
    @Test
    public void eliminarUnidadDeCasilleroFuncionaCorrectamente() {
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion, new JugadorNulo());

        Puntos puntos = new Puntos(20);
        Soldado soldado = new Soldado(puntos,posicion, new EmisarioNulo());
        casillero.guardarUnidad(soldado);
        casillero.eliminarUnidad();
        try {
            casillero.obtenerUnidad();
        }catch (CasilleroVacioExcepcion e){
            Assertions.assertEquals("El casillero esta vacio",e.getMessage());
        }

    }
}
