package fiuba.algo3.algochess.testintegracion;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.unidades.Curandero;
import fiuba.algo3.algochess.unidades.Soldado;
import org.testng.annotations.Test;

import org.junit.jupiter.api.Assertions;


public class AccionesSoldadoTest {

    // Prueba de fiuba.algo3.algochess.unidades.Soldado ataca fiuba.algo3.algochess.unidades.Curandero.
    @Test
    //Prueba con ataque de cerca.
    public void soldadoAtacaUnidadDeCerca() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(1,1);
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(soldado,curandero, 0.05);
        //Compruebo que el curandero se le haya restado la vida correctamente.
        Assertions.assertEquals(64.5,curandero.getVidaUnidad());
    }
    @Test
        //Prueba con ataque de distancia media.
    public void soldadoAtacaUnidadDeDistanciaMedia() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(4,4);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(soldado,curandero, 0.05);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }
    @Test
        //Prueba con ataque de distancia lejana.
    public void soldadoAtacaUnidadDeDistanciaLejana() throws Exception {
        Soldado soldado = new Soldado(1,1);
        Curandero curandero = new Curandero(7,7);
        AccionJugador accion = new AccionJugador();

        try {
            accion.accionNueva(soldado,curandero, 0.05);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }


}


