import Excepciones.CurarCatapultaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccionesCurarTest {

    @Test
        //Curandero cura a soldado

    void curanderoCuraSoldado() throws Exception {
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        Acciones accionCurar = new Acciones();

        // Curandero cura a Soldado.
        accionCurar.curarAUnidad(curandero, soldado);

        // Curacion curandero: 15 ---  Vida soldado: 100 // VidaFinalSoldado: 115
        assertEquals(115, soldado.getVida());
    }

    @Test
        //Prueba que se lanza error si se quiere curar catapulta.
    void curanderoCuraCatapulta() throws CurarCatapultaException {
        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        Acciones accionCurar = new Acciones();

        // Curandero no puede curar a Catapulta.
        try{
            accionCurar.curarAUnidad(curandero, catapulta);
        }catch (CurarCatapultaException e){
            assertEquals("No se puede curar a una catapulta",e.getMessage());
        }
    }

}