package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Vista.FaseJuego;
import fiuba.algo3.algochess.Vista.TableroInterfaz;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlarFaseAtaqueTest {

    @Test
    void seleccionarUnidadAtacante() {
        Juego juego = new Juego("nicolas","juani");
        GridPane tableroInterfaz = TableroInterfaz.crearTablero(juego.tablero, true);
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        // Unidades Aliadas
        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);

        // Unidades Enemigas
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        // Obtengo la primera de cada jugador
        Unidad unidadAtacante = juego.jugadorAliado.getUnidadesDisponibles().get(0);
        Unidad unidadAtacada = juego.jugadorEnemigo.getUnidadesDisponibles().get(0);

        // Ataco "desde la interfaz"
        ControlarFaseAtaque controlarFaseAtaque = new ControlarFaseAtaque(juego, tableroInterfaz);
        ControlarFaseAtaque.realizarAtaque(unidadAtacante, unidadAtacada);

        // Pruebo si el ataque fue realizado correctamente
        Assertions.assertEquals(30, unidadAtacada.getVidaUnidad());

    }

    @Test
    void seleccionarUnidadAtacada() {
    }

    @Test
    void realizarAtaque() {
    }
}