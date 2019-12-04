package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Jinete;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entrega2JineteTest {

    // Prueba de fiuba.algo3.algochess.unidades.Jinete ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void jineteEspadachinAtacaUnidadDeCerca() {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador, jugadorEnemigo);
        Posicion posicion = new Posicion(9, 9);
        Posicion posicionEnemiga = new Posicion(11, 11);
        tablero.crearUnidad(jugador, posicion, "jinete");
        tablero.crearUnidad(jugadorEnemigo, posicionEnemiga, "soldado");
        tablero.atacar(posicion, posicionEnemiga, jugador);

        Unidad unidadAtacada = jugadorEnemigo.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(95, unidadAtacada.getVidaUnidad());
    }
    //Tira exception por no estar en jinete espadachin, no agregar aliados cercanos

    @Test
    //Prueba con ataque de distancia media.
    public void jineteEspadachinAtacaUnidadDeDistanciaMedia() {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemigaMedia = new Posicion(13,13);
        Posicion posicionEnemigaCercana = new Posicion(10,10);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemigaMedia,"soldado");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemigaCercana,"soldado");
        try{
            tablero.atacar(posicion,posicionEnemigaMedia,jugador);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias medianas",e.getMessage());
        }
    }//Deberia estar tirando excepcion (no entra al try), agregarle un enemigo cerca

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteEspadachinAtacaUnidadDeDistanciaLejana() {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador, jugadorEnemigo);
        Posicion posicion = new Posicion(9, 9);
        Posicion posicionEnemigaCercana = new Posicion(10, 10);
        Posicion posicionEnemigaLejana = new Posicion(19, 19);
        tablero.crearUnidad(jugador, posicion, "jinete");
        tablero.crearUnidad(jugadorEnemigo, posicionEnemigaLejana, "soldado");
        tablero.crearUnidad(jugadorEnemigo, posicionEnemigaCercana, "soldado");
        try {
            tablero.atacar(posicion, posicionEnemigaLejana, jugador);
        } catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias lejanas", e.getMessage());
        }
    }

    @Test
    //Prueba con ataque de cerca.
    public void jineteArqueroAtacaUnidadDeCerca() {
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
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias cortas",e.getMessage());
        }
    }

    @Test
    //Prueba con ataque de distancia media.
    public void jineteArqueroAtacaUnidadDeDistanciaMedia() {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador,jugadorEnemigo);
        Posicion posicion = new Posicion(9,9);
        Posicion posicionEnemiga = new Posicion(13,13);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");
        tablero.atacar(posicion,posicionEnemiga,jugador);

        Unidad unidadAtacada = jugadorEnemigo.getUnidadesDisponibles().get(0);

        Assertions.assertEquals(85,unidadAtacada.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteArqueroAtacaUnidadDeDistanciaLejana() {
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
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, pudiendo atacar a distancia corta
    public void JineteSinAliadosCercaAtacaEnemigoCercanoConEspadaExitosamente() {
        Jugador jugador = new Jugador("tobias");
        Jugador jugadorEnemigo = new Jugador("francisco");
        Tablero tablero = new Tablero(jugador, jugadorEnemigo);

        Posicion posicion = new Posicion(4,4);
        Posicion posicionEnemiga = new Posicion(11,11);
        Posicion posicionEnemigaAux = new Posicion(10, 10);
        tablero.crearUnidad(jugador,posicion,"jinete");
        tablero.crearUnidad(jugadorEnemigo,posicionEnemiga,"soldado");

        tablero.moverUnidad(posicionEnemiga,posicionEnemigaAux,jugadorEnemigo);
        posicionEnemiga = new Posicion(10, 10);
        posicionEnemigaAux = new Posicion(9,9);

        tablero.moverUnidad(posicionEnemiga,posicionEnemigaAux,jugadorEnemigo);
        posicionEnemiga = new Posicion(9, 9);
        posicionEnemigaAux = new Posicion(8,8);

        tablero.moverUnidad(posicionEnemiga,posicionEnemigaAux,jugadorEnemigo);
        posicionEnemiga = new Posicion(8, 8);
        posicionEnemigaAux = new Posicion(7,7);
        tablero.moverUnidad(posicionEnemiga,posicionEnemigaAux,jugadorEnemigo);
        posicionEnemiga = new Posicion(7, 7);
        posicionEnemigaAux = new Posicion(6,6);
        tablero.moverUnidad(posicionEnemiga,posicionEnemigaAux,jugadorEnemigo);

        tablero.atacar(posicion,posicionEnemigaAux,jugador);

        Assertions.assertEquals(94.75,jugadorEnemigo.getUnidadesDisponibles().get(0).getVidaUnidad());
    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, siendo incapaz de atacar a distancia mediana
    public void JineteSinAliadosCercaConUnEnemigoCercanoNoPuedeAtacarAEnemigoEnDistanciaMedia() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionSoldadoEnemigo = new Posicion(11,11);
        Posicion posicionCuranderoEnemigo = new Posicion(11,1);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        tablero.crearUnidad(jugador2, posicionCuranderoEnemigo, "curandero");
        // Acerco el soldado enemigo a nuestro jinete a distancia cercana
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionSoldadoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        // Acerco el curandero enemigo a nuestro jinete a distancia media
        Posicion posicion1001 = new Posicion(10,1);
        Posicion posicion0901 = new Posicion(9,1);
        Posicion posicion0801 = new Posicion(8,1);
        Posicion posicion0701 = new Posicion(7,1);
        Posicion posicion0601 = new Posicion(6,1);
        Posicion posicion0501 = new Posicion(5,1);
        Posicion posicion0401 = new Posicion(4,1);

        tablero.moverUnidad(posicionCuranderoEnemigo, posicion1001, jugador2);
        tablero.moverUnidad(posicion1001, posicion0901, jugador2);
        tablero.moverUnidad(posicion0901, posicion0801, jugador2);
        tablero.moverUnidad(posicion0801, posicion0701, jugador2);
        tablero.moverUnidad(posicion0701, posicion0601, jugador2);
        tablero.moverUnidad(posicion0601, posicion0501, jugador2);
        tablero.moverUnidad(posicion0501, posicion0401, jugador2);
        // Intento atacar al curandero enemigo a distancia media
        try{
            tablero.atacar(posicionJinete, posicion0401, jugador1);
        }catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias medianas", e.getMessage());
        }
    }

    @Test
    //Jinete sin aliados ni enemigos cerca se le acerca un Soldado aliado y su estado sigue siendo Arquero
    public void AJineteSeLeAcercaSoldadoAliadoSinEnemigosCercaYSuEstadoSigueSiendoArquero() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionSoldado = new Posicion(4,1);
        Posicion posicion0402 = new Posicion(4,2);
        Posicion posicion0403 = new Posicion(4,3);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador1, posicionSoldado, "soldado");
        Jinete jinete = (Jinete) jugador1.getUnidadesDisponibles().get(0);
        Assertions.assertTrue(jinete.getEstado().esArquero());
        tablero.moverUnidad(posicionSoldado, posicion0402, jugador1);
        Assertions.assertTrue(jinete.getEstado().esArquero());
        tablero.moverUnidad(posicion0402, posicion0403, jugador1);
        Assertions.assertTrue(jinete.getEstado().esArquero());
    }

    @Test
    //Si a un jinete, por mas que tenga enemigos cerca, se le acerca un Soldado Aliado, se vuelve Arquero
    public void AJineteSeLeAcercaUnSoldadoAliadoConEnemigosCercaYCambiaSuModoAArquero() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionSoldado = new Posicion(1,1);
        Posicion posicionSoldadoEnemigo = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador1, posicionSoldado, "soldado");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        // Acerco el soldado enemigo a nuestro jinete
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionSoldadoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        // Acerco el soldado aliado a nuestro jinete
        Posicion posicion0202 = new Posicion(2,2);
        Posicion posicion0302 = new Posicion(3,2);
        Posicion posicion0402 = new Posicion(4,2);
        tablero.moverUnidad(posicionSoldado, posicion0202, jugador1);
        tablero.moverUnidad(posicion0202, posicion0302, jugador1);
        tablero.moverUnidad(posicion0302, posicion0402, jugador1);
        // Pruebo si el jinete está en modo arquero
        try{
            tablero.atacar(posicionJinete, posicion0604, jugador1);
        } catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias cortas", e.getMessage());
        }
    }

    @Test
    //Si a un jinete arquero sin aliados cerca, se le acerca un enemigo, se convierte en Espadachin
    public void AJineteSeLeAcercaEnemigoSinSoldadosAliadosCercaYCambiaSuModoAEspadachin() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionCuranderoEnemigo = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador2, posicionCuranderoEnemigo, "curandero");
        // Acerco el curandero enemigo a nuestro jinete
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionCuranderoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        tablero.atacar(posicionJinete, posicion0604,jugador1);
        Assertions.assertEquals(69.75, jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
    }

    @Test
    //Si a un jinete arquero con aliados cerca, se le acerca una unidad enemiga, este no cambia su estado de Arquero
    public void AJineteConSoldadoAliadoCercanoSeLeAcercaUnidadEnemigaYNoCambiaSuEstado() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionSoldado = new Posicion(4,2);
        Posicion posicionCuranderoEnemigo = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador1, posicionSoldado, "soldado");
        tablero.crearUnidad(jugador2, posicionCuranderoEnemigo, "curandero");
        // Acerco el curandero enemigo a nuestro jinete
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionCuranderoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        try{
            tablero.atacar(posicionJinete, posicion0604, jugador1);
        } catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias cortas", e.getMessage());
        }
    }

    @Test
    //SI a un jinete arquero, se la acerca un enemigo, teniendo aliados NO Soldados cerca, cambia de estado a Espadachin
    public void AJineteConAliadosNoSoldadosCercanosSeLeAcercaEnemigoYSuEstadoCambiaAEspadachin() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionCurandero = new Posicion(4,2);
        Posicion posicionCuranderoEnemigo = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador1, posicionCurandero, "curandero");
        tablero.crearUnidad(jugador2, posicionCuranderoEnemigo, "curandero");
        // Acerco el curandero enemigo a nuestro jinete
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionCuranderoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        // Pruebo si el jinete está en modo espadachin

        tablero.atacar(posicionJinete, posicion0604, jugador1);
        Assertions.assertEquals(69.75,jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
    }

    @Test
    //Si a un jinete espadachin, se le acercan Aliados no Soldados, no cambian su estado
    public void AJineteConEnemigosCercaSeLeAcercaAliadoNoSoldadoYNoCambiaSuEstado() {
        Jugador jugador1 = new Jugador("nicolas");
        Jugador jugador2 = new Jugador("tobias");
        Tablero tablero = new Tablero(jugador1, jugador2);
        Posicion posicionJinete = new Posicion(4,4);
        Posicion posicionCurandero = new Posicion(1,1);
        Posicion posicionSoldadoEnemigo = new Posicion(11,11);
        tablero.crearUnidad(jugador1, posicionJinete, "jinete");
        tablero.crearUnidad(jugador1, posicionCurandero, "curandero");
        tablero.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        // Acerco el soldado enemigo a nuestro jinete
        Posicion posicion1010 = new Posicion(10,10);
        Posicion posicion0909 = new Posicion(9,9);
        Posicion posicion0808 = new Posicion(8,8);
        Posicion posicion0707 = new Posicion(7,7);
        Posicion posicion0606 = new Posicion(6,6);
        Posicion posicion0605 = new Posicion(6,5);
        Posicion posicion0604 = new Posicion(6,4);
        tablero.moverUnidad(posicionSoldadoEnemigo, posicion1010, jugador2);
        tablero.moverUnidad(posicion1010, posicion0909, jugador2);
        tablero.moverUnidad(posicion0909, posicion0808, jugador2);
        tablero.moverUnidad(posicion0808, posicion0707, jugador2);
        tablero.moverUnidad(posicion0707, posicion0606, jugador2);
        tablero.moverUnidad(posicion0606, posicion0605, jugador2);
        tablero.moverUnidad(posicion0605, posicion0604, jugador2);
        // Acerco el curandero aliado a nuestro jinete
        Posicion posicion0202 = new Posicion(2,2);
        Posicion posicion0302 = new Posicion(3,2);
        Posicion posicion0402 = new Posicion(4,2);
        tablero.moverUnidad(posicionCurandero, posicion0202, jugador1);
        tablero.moverUnidad(posicion0202, posicion0302, jugador1);
        tablero.moverUnidad(posicion0302, posicion0402, jugador1);
        // Pruebo si el jinete está en modo espadachin
        tablero.atacar(posicionJinete, posicion0604, jugador1);
        Assertions.assertEquals(94.75,jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
    }
}
