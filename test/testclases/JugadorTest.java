import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JugadorTest {

    @Test
        // Creo un jugador y tiene 20 puntos disponibles
    public void jugadorArrancaConLosPuntosCorrectos() {
        Jugador jugador = new Jugador();
        Assertions.assertEquals(20,jugador.getPuntos());
    }
    @Test
        // Pruebo que un jugador recien creado no tiene unidades
    public void jugadorNuevoNoTieneUnidades(){
        Jugador jugador = new Jugador();
        Assertions.assertEquals(true,jugador.getUnidadesCreadas().isEmpty());
    }

    @Test
    // Jugador modifica los puntos correctamente.
    public void jugadorModificaPuntosYSusPuntosSeModifican(){
        Jugador jugador = new Jugador();
        jugador.modificarPuntos(10);
        Assertions.assertEquals(10,jugador.getPuntos());
    }

    @Test
        // jugador crea unidad correctamente.
    public void jugadorCreaUnidadYSuCantidadDeUnidadesAumentaEn1() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(1,jugador.getUnidadesCreadas().size());
    }

    @Test
        //jugador crea dos unidades y figura que posee las dos unidades
    public void jugadorCreaDosUnidadesYEfectivamentePoseeDosUnidades() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Soldado");
        jugador.crearUnidad("Curandero");
        Assertions.assertEquals(2, jugador.getUnidadesCreadas().size());
    }

    @Test
        //creacion de unidades invalidas (nombre inválido)
    public void jugadorCreaUnaUnidadInvalidaYSeAtrapaLaExcepcion() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        try{
            jugador.crearUnidad("Lancero"); //Lancero no es una unidad válida
        }
        catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad es invalida",e.getMessage());
        }
    }

    @Test
    //creacion de unidades invalidas
    public void jugadorCreaUnaUnidadInvalidaYSuContadorDeUnidadesNoVaria() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        try{
            jugador.crearUnidad("Lancero"); //Lancero no es una unidad válida
        }
        catch (UnidadInvalidaException e){
            Assertions.assertEquals(0,jugador.getUnidadesCreadas().size());
        }
    }

    @Test
    // Agrego un soldado y se modifican correctamente los puntos.
    public void jugadorAgregaUnidadSoldadoYSusPuntosSeDecrementanEn1() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(19,jugador.getPuntos());
    }

    @Test
    // Agrego Jinete y se modifican los puntos correctamente.
    public void jugadorAgregaUnidadJineteYSusPuntosSeDecrementanEn3() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Jinete");
        Assertions.assertEquals(17,jugador.getPuntos());
    }

    @Test
    // Agrego catapulta y se modifican los puntos correctamente.
    public void jugadorAgregaUnidadCatapultaYSusPuntosSeDecrementanEn5() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Catapulta");
        Assertions.assertEquals(15,jugador.getPuntos());
    }

    @Test
    // Agrego curandero y se modifican los puntos correctamente.
    public void jugadorAgregaUnidadCuranderoYSusPuntosSeDecrementanEn2() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("Curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }

    @Test
    //El jugador crea correctamente a pesar de pasar el nombre en minuscula.
    public void jugadorAgregaUnidadConElTextoEnMinusculaYEstaSeCreaCorrectamente() throws UnidadInvalidaException {
        Jugador jugador = new Jugador();
        jugador.crearUnidad("curandero");
        Assertions.assertEquals(18,jugador.getPuntos());
    }
}
