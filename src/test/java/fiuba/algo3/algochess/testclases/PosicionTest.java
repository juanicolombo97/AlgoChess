package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.Modelo.juego.Direccion;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosicionTest {

    @Test
    public void posicionCalculaDistanciaCorrectamente(){
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);

        Distancia distancia1 = posicion.calcularDistancia(posicion1);


        Assertions.assertEquals(1,distancia1.getDistanciaX());
        Assertions.assertEquals(1,distancia1.getDistanciaY());
    }

    @Test
    public void calcularDistanciaInvalidaLanzaError(){
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(3,3);
        try {
            posicion.distanciaValidaDesde(posicion1);
        }catch (MovimientoInvalidoException e){
            Assertions.assertEquals("Solo se mueve de a 1 casillero",e.getMessage());
        }
    }
    @Test
    public void calcularPosicionNuevaCorrectamente(){
        Posicion posicion = new Posicion(1,1);

        Direccion direccion = new Direccion(1,1);

        Posicion posicionNueva = posicion.posicionNueva(direccion);

        Assertions.assertEquals(2,posicionNueva.posicionX);

    }
}
