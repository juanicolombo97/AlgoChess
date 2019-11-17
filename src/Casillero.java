import Excepciones.CasilleroOcupadoExcenption;

public class Casillero {
    private Unidad unidad_actual;

    public void guardarUnidad(Unidad unidadNueva) {
       unidad_actual = unidadNueva;
   }


   public Unidad getUnidad(){
       return unidad_actual;
   }
}