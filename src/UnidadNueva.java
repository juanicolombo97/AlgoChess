public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidad crearUnidad(String unidad, int posicionX, int posicionY) throws excepciones.UnidadInvalidaException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidad unidadNueva = unidadesFabrica.crearUnidad(unidad,posicionX,posicionY);
        return unidadNueva;
    }
}
