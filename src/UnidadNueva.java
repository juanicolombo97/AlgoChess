import Excepciones.UnidadInvalidaException;

public class UnidadNueva {

    //Clase que recibe el nombre de la unidad a crear, la crea y se la devuelve al jugador.
    public Unidades crearUnidad(String unidadACrear) throws UnidadInvalidaException {
        UnidadesFabrica fabrica = new UnidadesFabrica();
        return fabrica.crearUnidad(unidadACrear);
    }
}
