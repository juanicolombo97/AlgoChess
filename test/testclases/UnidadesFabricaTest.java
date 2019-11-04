import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadesFabricaTest {

    boolean mismaClase;

    @Test
    //Pruebo que genere correctamente a la Unidad Soldado.
    public void creoUnidadesSoldado() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidades soldado = fabrica.crearUnidad("Soldado");
        Soldado soldado1 = new Soldado();
        mismaClase = soldado1.getClass().equals(soldado.getClass());
        assertEquals(true,mismaClase);
    }
    @Test
    //Pruebo que la fabrica genere correctamente al Jinete.
    public void creoUnidadesJinete() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidades jinete = fabrica.crearUnidad("Jinete");
        Jinete jinete1 = new Jinete();
        mismaClase = jinete1.getClass().equals(jinete.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear correctamente el Curandero.
    public void creoUnidadesCurandero() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidades curandero = fabrica.crearUnidad("Curandero");
        Curandero curandero1 = new Curandero();
        mismaClase = curandero1.getClass().equals(curandero.getClass());
        assertEquals(true,mismaClase);
    }

    @Test
    // Pruebo que se pueda crear la Catapulta.
    public void creoUnidadesCatapulta() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        Unidades catapulta = fabrica.crearUnidad("Catapulta");
        Catapulta catapulta1 = new Catapulta();
        mismaClase = catapulta1.getClass().equals(catapulta.getClass());
        assertEquals(true,mismaClase);
    }
    @Test
    // Pruebo que si intento crear una unidad invalida me da Excepcion.
    public void creoUnidadInvalida() throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        // codigo.Curandero no puede curar a codigo.Catapulta.
        try{
            fabrica.crearUnidad("Minion");
        }catch (UnidadInvalidaException e){
            assertEquals("La unidad es invalida",e.getMessage());
        }
    }
}

