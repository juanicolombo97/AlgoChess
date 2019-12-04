package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.CasilleroVacioExcepcion;
import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadesFabricaTest {

    boolean mismaClase;

    @Test
    //Pruebo que genere correctamente a la fiuba.algo3.algochess.Modelo.unidades.Unidad fiuba.algo3.algochess.Modelo.unidades.Soldado.
    public void creoUnidadesSoldado() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad soldado = fabrica.crearUnidad("soldado",puntos,posicion, new EmisarioNulo());
        Soldado soldado1 = new Soldado(puntos,posicion, new EmisarioNulo());
        mismaClase = soldado1.getClass().equals(soldado.getClass());
        assertEquals(100,soldado1.getVidaUnidad());
    }
    @Test
    //Pruebo que la fabrica genere correctamente al fiuba.algo3.algochess.Modelo.unidades.Jinete.
    public void creoUnidadesJinete() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad jinete = fabrica.crearUnidad("jinete",puntos,posicion, new EmisarioNulo());
        Jinete jinete1 = new Jinete(puntos,posicion, new EmisarioNulo());
        assertEquals(100,jinete1.getVidaUnidad());
    }

    @Test
    // Pruebo que se pueda crear correctamente el fiuba.algo3.algochess.Modelo.unidades.Curandero.
    public void creoUnidadesCurandero() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad curandero = fabrica.crearUnidad("curandero",puntos,posicion, new EmisarioNulo());
        Curandero curandero1 = new Curandero(puntos,posicion, new EmisarioNulo());
        assertEquals(75,curandero1.getVidaUnidad());
    }

    @Test
    // Pruebo que se pueda crear la fiuba.algo3.algochess.Modelo.unidades.Catapulta.
    public void creoUnidadesCatapulta() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad catapulta = fabrica.crearUnidad("catapulta",puntos,posicion, new EmisarioNulo());
        Catapulta catapulta1 = new Catapulta(puntos,posicion, new EmisarioNulo());
        assertEquals(50,catapulta1.getVidaUnidad());
    }

    @Test
    public void unidarInvalidaLanzaExcepcion() {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        try {
            Unidad catapulta = fabrica.crearUnidad("",puntos,posicion, new EmisarioNulo());
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad es invalida",e.getMessage());
        }
    }
}



