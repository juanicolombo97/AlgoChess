package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuntosTest {

    @Test
    public void puntosSuficientesNoTiraError() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        puntos.puntosSuficientes(10);
        Assertions.assertEquals(10,puntos.puntosDisponibles);
    }
    @Test
    public void puntosInsuficientesTiraError(){
        Puntos puntos = new Puntos(20);
        try {
            puntos.alcanzanPuntos(30);
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos insuficientes, dispone de: 20",e.getMessage());
        }
    }

}
