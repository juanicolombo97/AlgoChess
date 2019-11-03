import Excepciones.UnidadInvalidaException;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.

    public Unidades crearUnidad(String unidad) throws UnidadInvalidaException {
        if(unidad.equalsIgnoreCase("Soldado")){
            return new Soldado();
        }
        if(unidad.equalsIgnoreCase("Jinete")){
            return new Jinete();
        }
        if(unidad.equalsIgnoreCase("Curandero")){
            return new Curandero();
        }
        if(unidad.equalsIgnoreCase("Catapulta")){
            return new Catapulta();
        }
        // Error que se genera cuando se quiere crear una unidad invalida.
        throw new UnidadInvalidaException("La unidad es invalida");
    }
}
