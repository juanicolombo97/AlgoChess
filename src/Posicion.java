import Excepciones.MovimientoInvalidoException;

import java.util.Hashtable;

public class Posicion {

    private int posicionX, posicionY;
    public void posicionNueva(int posicionX, int posicionY){

        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void movimientoNuevo(int posicionX, int posicionY) throws MovimientoInvalidoException {
        int posicionFinalX = this.posicionX - posicionX;
        int posicionFinalY = this.posicionY - posicionY;

        //Verifico que no se mueva mas de un lugar.
        if (posicionFinalX < -1 || posicionFinalX > 1 || posicionFinalY < -1 || posicionFinalY > 1){
            throw new MovimientoInvalidoException("La unidad solo se mueve de a un casillero");
        }
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX(){
        return posicionX;
    }
    public int getPosicionY(){
        return posicionY;
    }

}
