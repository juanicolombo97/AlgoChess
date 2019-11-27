package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

import java.util.Hashtable;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.
    private Unidad unidadACrear;

    public Unidad crearUnidad(String unidad, int posicionX, int posicionY, Emisario emisario) throws UnidadInvalidaException {
        switch (unidad) {

            case "soldado": {
                unidadACrear = new Soldado(posicionX,posicionY,emisario);
                break;
            }
            case "jinete": {
                unidadACrear = new Jinete(posicionX,posicionY,emisario);
                break;
            }
            case "curandero": {
                unidadACrear = new Curandero(posicionX,posicionY,emisario);
                break;
            }
            case "catapulta": {
                unidadACrear = new Catapulta(posicionX,posicionY,emisario);
                break;
            }
        }
        return unidadACrear;
    }
}
