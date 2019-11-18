import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadesFabricaTest {

    boolean mismaClase;

    @Test
    //Pruebo que genere correctamente a la Unidad Soldado.
    public void creoUnidadesSoldado() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad soldado = fabrica.crearUnidad("Soldado",1,1);
        Soldado soldado1 = new Soldado(1,1);
        mismaClase = soldado1.getClass().equals(soldado.getClass());
        assertEquals(true,mismaClase);
    }
    @Test
    //Pruebo que la fabrica genere correctamente al Jinete.
    public void creoUnidadesJinete() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad jinete = fabrica.crearUnidad("Jinete",1,1);
        Jinete jinete1 = new Jinete(1,1);
        mismaClase = jinete1.getClass().equals(jinete.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear correctamente el Curandero.
    public void creoUnidadesCurandero() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad curandero = fabrica.crearUnidad("Curandero",1,1);
        Curandero curandero1 = new Curandero(1,1);
        mismaClase = curandero1.getClass().equals(curandero.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear la Catapulta.
    public void creoUnidadesCatapulta() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidad catapulta = fabrica.crearUnidad("Catapulta",1,1);
        Catapulta catapulta1 = new Catapulta(1,1);
        mismaClase = catapulta1.getClass().equals(catapulta.getClass());
        assertEquals(true,mismaClase);
    }
    @Test
    // Pruebo que si intento crear una unidad invalida me da Excepcion.
    public void creoUnidadInvalida() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        // codigo.Curandero no puede curar a codigo.Catapulta.
        try{
            fabrica.crearUnidad("Minion",1,1);
        }catch (UnidadInvalidaException e){
            assertEquals("La unidad es invalida",e.getMessage());
        }
    }
}


