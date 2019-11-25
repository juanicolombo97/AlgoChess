package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Curandero;
import fiuba.algo3.algochess.unidades.Jinete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesJineteTest {

    private Casillero[][] arrayCasillero;
    // Prueba de fiuba.algo3.algochess.unidades.Jinete ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void jineteEspadachinAtacaUnidadDeCerca() throws Exception {
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05, arrayCasillero);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(69.75,curandero.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia media.
    public void jineteEspadachinAtacaUnidadDeDistanciaMedia() throws Exception {
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(3,4);
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
        Jinete jinete = new Jinete(1, 1);
        jinete.setEstadoJinete("espadachin");
        Curandero curandero = new Curandero(7, 7);
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
        Jinete jinete = new Jinete(1, 1);
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(1, 1);
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
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(3,4);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(jinete,curandero, 0.05, arrayCasillero);
        //Compruebo que el curandero se le halla restado la vida correctamente.
        assertEquals(59.25,curandero.getVidaUnidad());
    }

    @Test
    //Prueba con ataque de distancia lejana.
    public void jineteArqueroAtacaUnidadDeDistanciaLejana() throws Exception {
        Jinete jinete = new Jinete(1, 1);
        jinete.setEstadoJinete("arquero");
        Curandero curandero = new Curandero(7, 7);
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

}
