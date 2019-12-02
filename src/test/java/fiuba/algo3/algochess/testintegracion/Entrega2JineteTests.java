package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entrega2JineteTests {

    // Prueba de fiuba.algo3.algochess.unidades.Jinete ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void jineteEspadachinAtacaUnidadDeCerca() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador, jugadorEnemigo);
        Posicion posicion = new Posicion(9, 9);
        Posicion posicionEnemiga = new Posicion(10, 10);
        tablero.crearUnidad(jugador, posicion, "jinete");
        tablero.crearUnidad(jugadorEnemigo, posicionEnemiga, "soldado");
        tablero.atacar(posicion, posicionEnemiga, jugador);

        Unidad unidadAtacada = jugadorEnemigo.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(95, unidadAtacada.getVidaUnidad());
    }
    //Tira exception por no estar en jinete espadachin, no agregar aliados cercanos

    @Test
    //Prueba con ataque de distancia media.
    public void jineteEspadachinAtacaUnidadDeDistanciaMedia() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(13,13);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");
        try{
            tablero.atacar(posicion,posicionEnemiga,jugador);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias medianas",e.getMessage());
        }
    }//Deberia estar tirando excepcion (no entra al try), agregarle un enemigo cerca

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteEspadachinAtacaUnidadDeDistanciaLejana() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(19,19);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");
        try{
            tablero.atacar(posicion,posicionEnemiga,jugador);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias lejanas",e.getMessage());
        }
    }// deberia tirar excepcion, falta emisario, agregarle otro

    @Test
    //Prueba con ataque de cerca.
    public void jineteArqueroAtacaUnidadDeCerca() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(10,10);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");
        try{
            tablero.atacar(posicion,posicionEnemiga,jugador);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias cercanas",e.getMessage());
        }
    }

    @Test
    //Prueba con ataque de distancia media.
    public void jineteArqueroAtacaUnidadDeDistanciaMedia() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(13,13);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");

        Unidad unidadAtacada = jugadorEnemigo.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(85,unidadAtacada.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteArqueroAtacaUnidadDeDistanciaLejana() throws Exception {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(19,19);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");
        try{
            tablero.atacar(posicion,posicionEnemiga,jugador);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, pudiendo atacar a distancia corta
    public void JineteSinAliadosCercaAtacaEnemigoCercanoConEspadaExitosamente() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CurarException {

    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, siendo incapaz de atacar a distancia mediana
    public void JineteSinAliadosCercaConUnEnemigoCercanoNoPuedeAtacarAEnemigoEnDistanciaMedia() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, MovimientoInvalidoException, NoAlcanzanLosPuntosException, CasilleroEnemigoException {

    }

    @Test
    //Jinete sin aliados ni enemigos cerca se le acerca un Soldado aliado y su estado sigue siendo Arquero
    public void AJineteSeLeAcercaSoldadoAliadoSinEnemigosCercaYSuEstadoSigueSiendoArquero() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, MovimientoInvalidoException {

    }

    @Test
    //Si a un jinete, por mas que tenga enemigos cerca, se le acerca un Soldado Aliado, se vuelve Arquero
    public void AJineteSeLeAcercaUnSoldadoAliadoConEnemigosCercaYCambiaSuModoAArquero() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, MovimientoInvalidoException, CurarException {

    }

    @Test
    //Si a un jinete arquero sin aliados cerca, se le acerca un enemigo, se convierte en Espadachin
    public void AJineteSeLeAcercaEnemigoSinSoldadosAliadosCercaYCambiaSuModoAEspadachin() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CurarException {

    }

    @Test
    //Si a un jinete arquero con aliados cerca, se le acerca una unidad enemiga, este no cambia su estado de Arquero
    public void AJineteConSoldadoAliadoCercanoSeLeAcercaUnidadEnemigaYNoCambiaSuEstado() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, MovimientoInvalidoException {

    }

    @Test
    //SI a un jinete arquero, se la acerca un enemigo, teniendo aliados NO Soldados cerca, cambia de estado a Espadachin
    public void AJineteConAliadosNoSoldadosCercanosSeLeAcercaEnemigoYSuEstadoCambiaAEspadachin() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CurarException {

    }

    @Test
    //Si a un jinete espadachin, se le acercan Aliados no Soldados, no cambian su estado
    public void AJineteConEnemigosCercaSeLeAcercaAliadoNoSoldadoYNoCambiaSuEstado() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, CasilleroEnemigoException, NoAlcanzanLosPuntosException, MovimientoInvalidoException, CurarException {

    }
}
