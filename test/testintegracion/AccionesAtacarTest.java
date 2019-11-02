import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AccionesAtacarTest {

    @Test
        // Prueba de Soldado ataca Curandero

    void soldadoAtacaUnidad() throws Exception {
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        Acciones accionAtacar = new Acciones();

        // Soldado ataca a curandero
        accionAtacar.atacarCuerpo(soldado,curandero);

        // Dano soldado: 10 ---  Vida curandero: 75 // VidaCuranderoPostAtaque: 65
        assertEquals(65,curandero.getVida());
    }

    @Test
        //Prueba Jinete ataca Soldado a distancia.

    void jineteAtacaUnidadADistancia() throws Exception {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();
        Acciones accionAtacar = new Acciones();

        // Jinete ataca a soldado.
        accionAtacar.atacarDistancia(jinete,soldado);

        // Dano Jinete: 15 ---  Vida soldado: 100 // VidaSoldadoPostAtaque: 85
        assertEquals(85,soldado.getVida());
    }

    @Test
        // Prueba Catapulta ataca a una unidad a larga distancia.

    void catapultaAtacaLargaDistancia() throws Exception {
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        Acciones accionAtacar = new Acciones();

        // Catapulta ataca a soldado.
        accionAtacar.atacarDistancia(catapulta,soldado);

        // Dano catapulta: 20 ---  Vida soldado: 100 // VidaCuranderoPostAtaque: 80
        assertEquals(80,soldado.getVida());
    }
}
