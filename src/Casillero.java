import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.MovimientoInvalidoException;

public class Casillero {
    private Unidad unidad_actual;

    public void guardarUnidad(Unidad unidadNueva) {
        unidad_actual = unidadNueva;
   }
   public void modificarUnidad(Unidad unidadNueva) throws MovimientoInvalidoException {
        UnidadNula unidadNula = new UnidadNula(0,0);

        //Si la unidad almacenada no es una unidad nula lanza error
        if(!unidad_actual.getClass().equals(unidadNula.getClass())){
            throw new MovimientoInvalidoException("El casillero esta ocupado");
        }
        unidad_actual = unidadNueva;
   }


   public Unidad getUnidad(){
       return unidad_actual;
   }
}