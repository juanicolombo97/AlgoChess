package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNula;
import javafx.css.CssMetaData;

public class Casillero {
    private UnidadNula unidadNula = new UnidadNula(0,0);
    private Unidad unidad_actual = unidadNula;
    private int posicionX;
    private int posicionY;

    public Casillero(int posInicialX,int posInicialY){
        this.posicionX = posInicialX;
        this.posicionY = posInicialY;
        unidad_actual = unidadNula;
    }

    public void guardarUnidad(Unidad unidadNueva) {
        unidad_actual = unidadNueva;
   }

    public void modificarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException {
        //Si la unidad almacenada no es una unidad nula lanza error
        if(!unidad_actual.getClass().equals(unidadNula.getClass())){
            throw new CasilleroOcupadoException("El casillero esta ocupado");
        }
        unidadNueva.getPosicion().posicionNueva(posicionX,posicionY);
        unidad_actual = unidadNueva;

   }

   public void moverUnidad(Casillero casilleroDestino) throws CasilleroOcupadoException {
        casilleroDestino.modificarUnidad(unidad_actual);

        unidad_actual = unidadNula;
   }
   public Unidad getUnidad(){
       return unidad_actual;
   }

}