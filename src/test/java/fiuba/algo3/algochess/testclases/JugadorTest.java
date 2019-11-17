package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.*;
import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    @Test
        // Creo un jugador y no tiene unidades.
    void jugadorRecienCreadoPuedeJugar(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }

    @Test
        // fiuba.algochess.Jugador agrega unidad

    void jugadorPuedeAgregarUnidad() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Jugador jugador = new Jugador("Juani");
        Casillero casillero = new Casillero();
        jugador.agregarCasillero(casillero);
        jugador.crearUnidad(1,1,"soldado",casillero);
        Assertions.assertEquals(true,jugador.puedeSeguirJugando());
    }

    @Test
        //fiuba.algochess.Jugador puede atacar correctamente
    void jugadorPuedeAtacarCorrectamente() throws NoPuedeAtacarException, CurarException {
        Jugador jugador = new Jugador("Juani");
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);

        jugador.atacar(soldado,curandero);
        Assertions.assertEquals(65,curandero.getVidaUnidad());
    }

    @Test
        //Se verifica que no puede tomar mas de los puntos que le corresponden

    void crearUnidadesDeMasLanzaError() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Jugador jugador = new Jugador("Juani");
        Casillero casillero = new Casillero();
        Casillero casillero2 = new Casillero();
        Casillero casillero3 = new Casillero();
        Casillero casillero4= new Casillero();
        Casillero casillero5= new Casillero();

        jugador.agregarCasillero(casillero);
        jugador.agregarCasillero(casillero2);
        jugador.agregarCasillero(casillero3);
        jugador.agregarCasillero(casillero4);
        jugador.agregarCasillero(casillero5);

        //Agrego 4 catapultas de valor 5, puntos jugador = 20;
        jugador.crearUnidad(1,1,"catapulta",casillero);
        jugador.crearUnidad(1,1,"catapulta",casillero2);
        jugador.crearUnidad(1,1,"catapulta",casillero3);
        jugador.crearUnidad(1,1,"catapulta",casillero4);
        //Agregar soldado genera error.
        try {
            jugador.crearUnidad(1,1,"soldado",casillero5);
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos insuficientes",e.getMessage());
        }

    }
    @Test
        //fiuba.algochess.Jugador con una pieza, al morir la pieza pierde.
    void jugadorPierdeSiNoTieneFichas() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, NoPuedeAtacarException, CurarException, CasilleroEnemigoException, CasilleroOcupadoException {
        Jugador jugador = new Jugador("juan");
        Casillero casillero = new Casillero();

        jugador.agregarCasillero(casillero);
        jugador.crearUnidad(1,1,"soldado",casillero);

        //Creo catapulta para atacar a soldado y matarlo
        Catapulta catapulta = new Catapulta(7,7);

        Unidad unidadSoldado = (Unidad) jugador.unidadesDisponibles().get(0);
        //Ataco 4 veces para matar al soldado.
        jugador.atacar(catapulta,unidadSoldado);
        jugador.atacar(catapulta,unidadSoldado);
        jugador.atacar(catapulta,unidadSoldado);
        jugador.atacar(catapulta,unidadSoldado);
        jugador.atacar(catapulta,unidadSoldado);
        //Actualizador de unidades(modificar una ves echo tablero)
        jugador.revisionUnidades();
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());


    }
}



