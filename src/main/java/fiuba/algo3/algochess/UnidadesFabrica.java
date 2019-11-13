package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.

    public Unidad crearUnidad(String unidad, int posicionX, int posicionY) throws UnidadInvalidaException {
        if(unidad.equalsIgnoreCase("fiuba.algochess.Soldado")){
            return new Soldado(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("fiuba.algochess.Jinete")){
            return new Jinete(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("fiuba.algochess.Curandero")){
            return new Curandero(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("fiuba.algochess.Catapulta")){
            return new Catapulta(posicionX,posicionY);
        }
        // Error que se genera cuando se quiere crear una unidad invalida.
        throw new UnidadInvalidaException("La unidad es invalida");
    }
}
