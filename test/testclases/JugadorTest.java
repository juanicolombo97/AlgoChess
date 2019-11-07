import Excepciones.*;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//TODO: si se siguen añadiendo, siguen bajando los puntos, y sigue incrementando cantidad unidades (agrega unidades)
//TODO: (integracion) si puedo seguir jugando el juego no termina,
//TODO: si al jugador le quedan unidades, sigue el juego (size != 0)
//TODO: si se elimina una unidad, el contador de unidades baja
//TODO: si el jugador se queda sin puntos y quiere agregar unidades, se atrapa a excepcion adecuada

public class JugadorTest {

    @Test
        // Creo un jugador y no tiene unidades.
    void jugadorRecienCreadoPuedeJugar(){
        Jugador jugador = new Jugador("Juani");
        Assertions.assertEquals(false,jugador.puedeSeguirJugando());
    }

    @Test
        // Jugador agrega unidad

    void jugadorPuedeAgregarUnidad() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        Jugador jugador = new Jugador("Juani");
        Casillero casillero = new Casillero();
        jugador.agregarCasillero(casillero);
        jugador.crearUnidad(1,1,"soldado",casillero);
        Assertions.assertEquals(true,jugador.puedeSeguirJugando());
    }

    @Test
        //Jugador puede atacar correctamente
    void jugadorPuedeAtacarCorrectamente() throws NoPuedeAtacarException, CurarException {
        Jugador jugador = new Jugador("Juani");
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);

        jugador.atacar(soldado,curandero);
        Assertions.assertEquals(65,curandero.getVidaUnidad());
    }

    @Test
        //Se verifica que no puede tomar mas de los puntos que le corresponden

    void crearUnidadesDeMasLanzaError() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
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
        //Jugador con una pieza, al morir la pieza pierde.
    void jugadorPierdeSiNoTieneFichas() throws NoAlcanzanLosPuntosException, UnidadInvalidaException, NoPuedeAtacarException, CurarException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        Jugador jugador = new Jugador("juan");
        Casillero casillero = new Casillero();

        jugador.agregarCasillero(casillero);
        jugador.crearUnidad(1,1,"soldado",casillero);

        //Creo catapulta para atacar a soldado y matarlo
        Catapulta catapulta = new Catapulta(7,7);

        Unidades unidadSoldado = (Unidades) jugador.unidadesDisponibles().get(0);
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



