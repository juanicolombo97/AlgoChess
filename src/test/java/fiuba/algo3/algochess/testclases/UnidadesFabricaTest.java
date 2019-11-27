package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.juego.Puntos;
import fiuba.algo3.algochess.unidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadesFabricaTest {

    boolean mismaClase;

    @Test
    //Pruebo que genere correctamente a la fiuba.algo3.algochess.unidades.Unidad fiuba.algo3.algochess.unidades.Soldado.
    public void creoUnidadesSoldado() throws UnidadInvalidaException , NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad soldado = fabrica.crearUnidad("soldado",puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion);
        mismaClase = soldado1.getClass().equals(soldado.getClass());
        assertEquals(true,mismaClase);
    }
    @Test
    //Pruebo que la fabrica genere correctamente al fiuba.algo3.algochess.unidades.Jinete.
    public void creoUnidadesJinete() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad jinete = fabrica.crearUnidad("jinete",puntos,posicion);
        Jinete jinete1 = new Jinete(puntos,posicion);
        mismaClase = jinete1.getClass().equals(jinete.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear correctamente el fiuba.algo3.algochess.unidades.Curandero.
    public void creoUnidadesCurandero() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad curandero = fabrica.crearUnidad("curandero",puntos,posicion);
        Curandero curandero1 = new Curandero(puntos,posicion);
        mismaClase = curandero1.getClass().equals(curandero.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear la fiuba.algo3.algochess.unidades.Catapulta.
    public void creoUnidadesCatapulta() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad catapulta = fabrica.crearUnidad("catapulta",puntos,posicion);
        Catapulta catapulta1 = new Catapulta(puntos,posicion);
        mismaClase = catapulta1.getClass().equals(catapulta.getClass());
        assertEquals(true,mismaClase);
    }

}



