package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNula;
import javafx.css.CssMetaData;

public class Casillero {
    private UnidadNula unidadNula = new UnidadNula(0,0);
    private Unidad unidad_actual;
    private int posicionX;
    private int posicionY;

    public Casillero(int posInicialX,int posInicialY){
        this.posicionX = posInicialX;
        this.posicionY = posInicialY;
        unidad_actual = unidadNula;
    }

    public void guardarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException {
        //Si la unidad almacenada no es una unidad nula lanza error
        if(!unidad_actual.getClass().equals(unidadNula.getClass())){
            throw new CasilleroOcupadoException("El casillero esta ocupado");
        }
        unidad_actual = unidadNueva;
   }

    public void modificarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException, UnidadNulaException, MovimientoInvalidoException {
        unidadNueva.moverUnidad(posicionX,posicionY);
        guardarUnidad(unidadNueva);
        unidadNueva.modificarPosicion(posicionX,posicionY);

   }

   public void moverUnidad(Casillero casilleroDestino) throws CasilleroOcupadoException, UnidadNulaException, MovimientoInvalidoException {
        casilleroDestino.modificarUnidad(unidad_actual);

        unidad_actual = unidadNula;
   }
   public Unidad getUnidad(){
       return unidad_actual;
   }

}