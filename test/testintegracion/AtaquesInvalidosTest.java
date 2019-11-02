import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class AtaquesInvalidosTest {
    @Test
        // Prueba Catapulta ataca a corta distancia y tira error.

    void catapultaAtacaSoldadoACortaDist() throws NoPuedeAtacarException {
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        Acciones accionAtacar = new Acciones();
        try {
            // Catapulta ataca a soldado a corta distancia.
            accionAtacar.atacarCuerpo(catapulta, soldado);
        }catch (NoPuedeAtacarException e) {
            assertEquals("La catapulta no puede atacar cuerpo a cuerpo",e.getMessage());
        }
    }

    @Test
        // Curandero no puede atacar a nadie corta distancia
    void curanderoAtacaSoldadoCortaDistancia() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        Acciones accionAtacar = new Acciones();
        try{
            accionAtacar.atacarCuerpo(curandero,soldado);
        }catch (NoPuedeAtacarException e){
            assertEquals("El curandero no puede atacar.",e.getMessage());
        }
    }

    @Test
        // Curandero no puede atacar a larga distancia
    void curanderoAtacaLargaDist() throws NoPuedeAtacarException {
        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        Acciones accionAtacar = new Acciones();
        try{
            accionAtacar.atacarCuerpo(curandero,catapulta);
        }catch (NoPuedeAtacarException e){
            assertEquals("El curandero no puede atacar.",e.getMessage());
        }
    }

    @Test
        // Soldado no puede atacar a larga distancia
    void soldadoAtacaLargaDistancia() throws NoPuedeAtacarException {
        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        Acciones accion = new Acciones();

        try{
            accion.atacarDistancia(soldado,jinete);
        }catch (NoPuedeAtacarException e){
            assertEquals("El soldado solo ataca cuerpo a cuerpo",e.getMessage());
        }
    }
}

