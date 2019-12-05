package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.Modelo.excepciones.FaseCreacionUnidadesFinalizoException;
import fiuba.algo3.algochess.Modelo.excepciones.FaseJuegoNoComienzaAunException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;
import fiuba.algo3.algochess.Modelo.juego.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JuegoTest {

    @Test
    public void comenzarJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
    }

    @Test
    public void elTurnoEsDelJugador1yNoDelJugador2(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        try{
            Posicion posicion = new Posicion(10,11);
            juego.crearUnidad(jugador2, posicion, "soldado");
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
    }

    @Test
    public void crearUnidadesDeUnJugador(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        Posicion posicionSoldado2 = new Posicion(1,1);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        try {
            juego.crearUnidad(jugador1, posicionSoldado2, "soldado");
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
    }

    @Test
    public void cambioDeFaseAFaseJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        try {
            juego.crearUnidad(jugador2, posicionSoldadoEnemigo2, "soldado");
        } catch (FaseCreacionUnidadesFinalizoException e){
            Assertions.assertEquals("La fase de creación de unidades ya finalizó", e.getMessage());
        }
    }

    @Test
    public void noEsPosibleMoverEnFaseDeCreacionDeUnidades(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionDestino = new Posicion(9,2);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        try {
            juego.realizarMovimiento(posicionSoldado, posicionDestino, jugador1);
        } catch (FaseJuegoNoComienzaAunException e){
            Assertions.assertEquals("La fase de juego aun no ha comenzado", e.getMessage());
        }
    }

    @Test
    public void noEsPosibleAtacarEnFaseDeCreacionDeUnidades(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        try {
            juego.realizarAtaque(posicionSoldadoEnemigo, posicionSoldado, jugador2);
        } catch (FaseJuegoNoComienzaAunException e){
            Assertions.assertEquals("La fase de juego aun no ha comenzado", e.getMessage());
        }
    }

    @Test
    public void turnoDelOtroJugadorEnFaseJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        juego.cambiarTurno();
        // Cambio de fase a FaseJuego
        Posicion posicionDestinoSoldadoEnemigo = new Posicion(10,1);
        try {
            juego.realizarMovimiento(posicionSoldadoEnemigo, posicionDestinoSoldadoEnemigo, jugador2);
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }

    }

    @Test
    public void MoverEnFaseJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        juego.cambiarTurno();
        // Cambio de fase a FaseJuego
        Posicion posicionDestinoSoldado = new Posicion(10,1);
        juego.realizarMovimiento(posicionSoldado, posicionDestinoSoldado, jugador1);
        Assertions.assertEquals(posicionDestinoSoldado, jugador1.getUnidadesDisponibles().get(0).getPosicion());
    }

    @Test
    public void AtacarEnFaseJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        juego.cambiarTurno();
        // Cambio de fase a FaseJuego
        juego.realizarAtaque(posicionSoldado, posicionSoldadoEnemigo, jugador1);
        Assertions.assertEquals(90, jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
    }

    @Test
    public void cambioDeTurnosEnFaseJuego(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        juego.cambiarTurno();
        // Cambio de fase a FaseJuego
        // Turno de jugador 1
        juego.realizarAtaque(posicionSoldado, posicionSoldadoEnemigo, jugador1);
        Assertions.assertEquals(90, jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
        // Turno de jugador 2
        // Pruebo que al tratar de ejecutar una accion como jugador 1 no me lo permite
        try{
            juego.realizarAtaque(posicionSoldado, posicionSoldadoEnemigo, jugador1);
        } catch (TurnoJugadorException e){
            Assertions.assertEquals("Es el turno del otro jugador", e.getMessage());
        }
        // Realizo accion con jugador 2
        juego.realizarAtaque(posicionSoldadoEnemigo, posicionSoldado, jugador2);
        Assertions.assertEquals(90, jugador1.getUnidadesDisponibles().get(0).getVidaUnidad());
    }

    @Test
    public void prueboCuatroTurnosDeAtaqueEntreSoldados(){
        Jugador jugador1 = new JugadorReal("nicolas");
        Jugador jugador2 = new JugadorReal("juani");
        Juego juego = new Juego(jugador1, jugador2);
        Tablero tableroDeJuego = juego.comenzarJuego();
        Posicion posicionSoldado = new Posicion(9,1);
        Posicion posicionCurandero1 = new Posicion(7,2);
        Posicion posicionCurandero2 = new Posicion(7,1);
        Posicion posicionCatapulta = new Posicion(1,6);
        Posicion posicionCatapulta2 = new Posicion(4,6);
        Posicion posicionCatapulta3 = new Posicion(7,6);
        juego.crearUnidad(jugador1, posicionSoldado, "soldado");
        juego.crearUnidad(jugador1, posicionCurandero1, "curandero");
        juego.crearUnidad(jugador1, posicionCurandero2, "curandero");
        juego.crearUnidad(jugador1, posicionCatapulta, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta2, "catapulta");
        juego.crearUnidad(jugador1, posicionCatapulta3, "catapulta");
        juego.cambiarTurno();
        Posicion posicionSoldadoEnemigo = new Posicion(11,1);
        Posicion posicionCuranderoEnemigo1 = new Posicion(13,2);
        Posicion posicionCuranderoEnemigo2 = new Posicion(13,1);
        Posicion posicionCatapultaEnemiga = new Posicion(19,6);
        Posicion posicionCatapultaEnemiga2 = new Posicion(19,5);
        Posicion posicionCatapultaEnemiga3 = new Posicion(19,4);
        Posicion posicionSoldadoEnemigo2 = new Posicion(19,20);
        juego.crearUnidad(jugador2, posicionSoldadoEnemigo, "soldado");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo1, "curandero");
        juego.crearUnidad(jugador2, posicionCuranderoEnemigo2, "curandero");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga2, "catapulta");
        juego.crearUnidad(jugador2, posicionCatapultaEnemiga3, "catapulta");
        // Cambio de fase a FaseJuego
        juego.cambiarTurno();
        // Turno de jugador 1
        juego.realizarAtaque(posicionSoldado, posicionSoldadoEnemigo, jugador1);
        Assertions.assertEquals(90, jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
        juego.cambiarTurno();
        // Turno de jugador 2
        juego.realizarAtaque(posicionSoldadoEnemigo, posicionSoldado, jugador2);
        Assertions.assertEquals(90, jugador1.getUnidadesDisponibles().get(0).getVidaUnidad());
        juego.cambiarTurno();
        // Turno de jugador 1
        juego.realizarAtaque(posicionSoldado, posicionSoldadoEnemigo, jugador1);
        Assertions.assertEquals(80, jugador2.getUnidadesDisponibles().get(0).getVidaUnidad());
        juego.cambiarTurno();
        // Turno de jugador 2
        juego.realizarAtaque(posicionSoldadoEnemigo, posicionSoldado, jugador2);
        Assertions.assertEquals(80, jugador1.getUnidadesDisponibles().get(0).getVidaUnidad());
    }


}