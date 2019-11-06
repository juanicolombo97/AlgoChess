public class UnidadNueva {

    //Creo una fabrica de unidades.
    public Unidades crearUnidad(String unidad, int posicionX,int posicionY) throws excepciones.UnidadInvalidaException {
        UnidadesFabrica unidadesFabrica = new UnidadesFabrica();
        Unidades unidadNueva = unidadesFabrica.crearUnidad(unidad,posicionX,posicionY);
        return unidadNueva;
    }
}
