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

}