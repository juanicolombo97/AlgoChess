package fiuba.algo3.algochess.unidades;

public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidad crearUnidad(String unidad, int posicionX, int posicionY, Emisario emisario) throws fiuba.algo3.algochess.excepciones.UnidadInvalidaException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidad unidadNueva = unidadesFabrica.crearUnidad(unidad.toLowerCase(),posicionX,posicionY, emisario);
        return unidadNueva;
    }
}
