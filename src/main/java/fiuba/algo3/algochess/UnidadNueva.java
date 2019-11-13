package fiuba.algo3.algochess;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidades crearUnidad(String unidad, int posicionX,int posicionY) throws UnidadInvalidaException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidades unidadNueva = unidadesFabrica.crearUnidad(unidad,posicionX,posicionY);
        return unidadNueva;
    }
}
