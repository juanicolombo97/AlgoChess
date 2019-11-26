package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import fiuba.algo3.algochess.unidades.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesJineteTest {

    private Casillero[][] arrayCasillero;
    // Prueba de fiuba.algo3.algochess.unidades.Jinete ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void jineteEspadachinAtacaUnidadDeCerca() throws Exception {
        Jinete jinete = new Jinete(1,1, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(1,1, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05, arrayCasillero);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(69.75,curandero.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia media.
    public void jineteEspadachinAtacaUnidadDeDistanciaMedia() throws Exception {
        Jinete jinete = new Jinete(1,1, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(3,4, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(jinete, curandero, 0.05, arrayCasillero);
        } catch (NoPuedeAtacarException e) {
            assertEquals("El jinete espadachin no puede atacar a distancias medianas", e.getMessage());
        }
    }

    @Test
        //Prueba con ataque de distancia lejana.
    public void jineteEspadachinAtacaUnidadDeDistanciaLejana() throws Exception {
        Jinete jinete = new Jinete(1, 1, new EmisarioNulo());
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(7, 7, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(jinete, curandero, 0.05, arrayCasillero);
        } catch (NoPuedeAtacarException e) {
            assertEquals("El jinete espadachin no puede atacar a distancias lejanas", e.getMessage());
        }
    }

    @Test
    //Prueba con ataque de cerca.
    public void jineteArqueroAtacaUnidadDeCerca() throws Exception {
        Jinete jinete = new Jinete(1, 1, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(1, 1, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(jinete, curandero, 0.05, arrayCasillero);
        } catch (NoPuedeAtacarException e) {
            assertEquals("El jinete arquero no puede atacar a distancias cortas", e.getMessage());
        }
    }

    @Test
    //Prueba con ataque de distancia media.
    public void jineteArqueroAtacaUnidadDeDistanciaMedia() throws Exception {
        Jinete jinete = new Jinete(1,1, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(3,4, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05, arrayCasillero);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(59.25,curandero.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteArqueroAtacaUnidadDeDistanciaLejana() throws Exception {
        Jinete jinete = new Jinete(1, 1, new EmisarioNulo());
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(7, 7, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(jinete, curandero, 0.05, arrayCasillero);
        } catch (NoPuedeAtacarException e) {
            assertEquals("El jinete arquero no puede atacar a distancias lejanas", e.getMessage());
        }
    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, pudiendo atacar a distancia corta
    public void JineteSinAliadosCercaAtacaEnemigoCercanoConEspadaExitosamente() throws NoPuedeAtacarException, UnidadNulaException{

    }

    @Test
    //Jinete con un enemigo cerca, SIN aliados cerca, esta en modo Espadachin, siendo incapaz de atacar a distancia mediana
    public void JineteSinAliadosCercaConUnEnemigoCercanoNoPuedeAtacarAEnemigoEnDistanciaMedia() throws NoPuedeAtacarException, UnidadNulaException {

    }

    @Test
    //Jinete sin aliados ni enemigos cerca se le acerca un Soldado aliado y su estado sigue siendo Arquero
    public void AJineteSeLeAcercaSoldadoAliadoSinEnemigosCercaYSuEstadoSigueSiendoArquero() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, MovimientoInvalidoException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        tablero.crearUnidad(jugador1, 4,4, "jinete");
        tablero.crearUnidad(jugador1, 4, 1, "soldado");
        ArrayList unidadesJugador1 = jugador1.getUnidadesDisponibles();
        Jinete jinete = (Jinete) unidadesJugador1.get(0);
        JineteArquero estadoArquero = new JineteArquero();
        Assert.assertEquals(estadoArquero.getClass(), jinete.getEstado().getClass());
        tablero.moverUnidad(4,1,4,2,jugador1);
        Assert.assertEquals(estadoArquero.getClass(), jinete.getEstado().getClass());
        tablero.moverUnidad(4,2,4,3,jugador1);
        Assert.assertEquals(estadoArquero.getClass(), jinete.getEstado().getClass());
    }

    @Test
    //Si a un jinete, por mas que tenga enemigos cerca, se le acerca un Soldado Aliado, se vuelve Arquero
    public void AJineteSeLeAcercaUnSoldadoAliadoConEnemigosCercaYCambiaSuModoAArquero() throws NoPuedeAtacarException, UnidadNulaException, CasilleroOcupadoException, UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, MovimientoInvalidoException, CurarException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        tablero.crearUnidad(jugador1, 4,4, "jinete");
        tablero.crearUnidad(jugador1, 1, 1, "soldado");
        tablero.crearUnidad(jugador2, 11, 11, "soldado");
        // Acerco el soldado enemigo a nuestro jinete
        tablero.moverUnidad(11,11,10,10, jugador2);
        tablero.moverUnidad(10,10,9,9, jugador2);
        tablero.moverUnidad(9,9,8,8, jugador2);
        tablero.moverUnidad(8,8,7,7, jugador2);
        tablero.moverUnidad(7,7,6,6, jugador2);
        tablero.moverUnidad(6,6,6,5, jugador2);
        tablero.moverUnidad(6,5,6,4, jugador2);
        // Acerco el soldado aliado a nuestro jinete
        tablero.moverUnidad(1,1,2,2, jugador1);
        tablero.moverUnidad(2,2,3,2, jugador1);
        tablero.moverUnidad(3,2,4,2, jugador1);
        // Pruebo si el jinete está en modo arquero
        try{
            tablero.atacar(4,4,6,4, jugador1);
        } catch (NoPuedeAtacarException e){
            e.printStackTrace();
        }
    }

    @Test
    //Si a un jinete arquero sin aliados cerca, se le acerca un enemigo, se convierte en Espadachin
    public void AJineteSeLeAcercaEnemigoSinSoldadosAliadosCercaYCambiaSuModoAEspadachin() throws NoPuedeAtacarException, UnidadNulaException {

    }

    @Test
    //Si a un jinete arquero con aliados cerca, se le acerca una unidad enemiga, este no cambia su estado de Arquero
    public void AJineteConSoldadoAliadoCercanoSeLeAcercaUnidadEnemigaYNoCambiaSuEstado() throws NoPuedeAtacarException, UnidadNulaException {

    }

    @Test
    //SI a un jinete arquero, se la acerca un enemigo, teniendo aliados NO Soldados cerca, cambia de estado a Espadachin
    public void AJineteConAliadosNoSoldadosCercanosSeLeAcercaEnemigoYSuEstadoCambiaAEspadachin() throws NoPuedeAtacarException, UnidadNulaException {

    }

    @Test
    //Si a un jinete espadachin, se le acercan Aliados no Soldados, no cambian su estado
    public void AJineteConEnemigosCercaSeLeAcercaAliadoNoSoldadoYNoCambiaSuEstadoAEspadachin() throws NoPuedeAtacarException, UnidadNulaException {

    }

}
