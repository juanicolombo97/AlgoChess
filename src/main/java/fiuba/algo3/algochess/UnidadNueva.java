package fiuba.algo3.algochess;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidad crearUnidad(String unidad, int posicionX, int posicionY) throws UnidadInvalidaException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidad unidadNueva = unidadesFabrica.crearUnidad(unidad,posicionX,posicionY);
        return unidadNueva;
    }
}
