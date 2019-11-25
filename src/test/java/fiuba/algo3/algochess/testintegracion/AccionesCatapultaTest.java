package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Catapulta;
import fiuba.algo3.algochess.unidades.EmisarioNulo;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionesCatapultaTest {
    // Prueba de fiuba.algo3.algochess.unidades.Catapulta atacando soldado.

    private Casillero[][] arrayCasillero;
    @Test
    //Prueba con ataque de cerca.
    public void catapultaAtacaDeCerca() throws Exception {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        Catapulta catapulta = new Catapulta(2,2, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();
        try {
            accion.accionNueva(catapulta,soldado, 0.05, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
    @Test
    //Prueba con ataque distancia media.
    public void catapultaAtacaDeDistanciaMedia() throws Exception {
        Soldado soldado = new Soldado(1,1, new EmisarioNulo());
        Catapulta catapulta = new Catapulta(4,4, new EmisarioNulo());
        AccionJugador accion = new AccionJugador();
        try {
            accion.accionNueva(catapulta,soldado, 0.05, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            assertEquals("La catapulta solo ataca a distancia",e.getMessage());
        }

    }
}
