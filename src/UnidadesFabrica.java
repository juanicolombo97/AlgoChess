import excepciones.UnidadInvalidaException;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.

    public Unidades crearUnidad(String unidad,int posicionX,int posicionY) throws UnidadInvalidaException {
        if(unidad.equalsIgnoreCase("Soldado")){
            return new Soldado(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("Jinete")){
            return new Jinete(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("Curandero")){
            return new Curandero(posicionX,posicionY);
        }
        if(unidad.equalsIgnoreCase("Catapulta")){
            return new Catapulta(posicionX,posicionY);
        }
        // Error que se genera cuando se quiere crear una unidad invalida.
        throw new UnidadInvalidaException("La unidad es invalida");
    }
}
