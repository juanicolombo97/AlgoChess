package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.unidades.*;

import java.util.ArrayList;

public class Casillero {
    private UnidadNula unidadNula = new UnidadNula(0,0, new EmisarioNulo());
    private Unidad unidad_actual;
    private int posicionX;
    private int posicionY;
    private Soldado soldado = new Soldado(0,0, new EmisarioNulo());
    private Batallon batallon = new Batallon();
    private int contador = 0;

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

   public void moverUnidad(Casillero casilleroDestino, Casillero[][] arrayCasillero) throws CasilleroOcupadoException, UnidadNulaException, MovimientoInvalidoException {
        if (unidad_actual.getClass().equals(soldado.getClass())){
            int distanciaX = casilleroDestino.posicionX - posicionX;
            int distanciaY = casilleroDestino.posicionY - posicionY;
            moverBatallon(distanciaX,distanciaY,arrayCasillero);
        }
        else {
            moverUnidadSolitaria(casilleroDestino.posicionX,casilleroDestino.posicionY,arrayCasillero);
        }

   }

   public Unidad getUnidad(){
       return unidad_actual;
   }

   private void moverBatallon(int distanciaX,int distanciaY,Casillero[][] casilleros) throws UnidadNulaException, CasilleroOcupadoException, MovimientoInvalidoException {
       ArrayList listaUnidades = batallon.calcularBatallonDeSoldados(unidad_actual,casilleros);
       if (listaUnidades.size() < 3){
           int posX = posicionX + distanciaX;
           int posY = posicionY + distanciaY;
           moverUnidadSolitaria(posX,posY,casilleros);
       }else {
           while (listaUnidades.size() != 0 && contador !=3){
               Soldado soldado = (Soldado) listaUnidades.remove(0);
               int posicionSoldadoX = soldado.getPosicion().getPosicionX();
               int posicionSoldadoY = soldado.getPosicion().getPosicionY();
               try {
                   casilleros[posicionSoldadoX + distanciaX][posicionSoldadoY + distanciaY].modificarUnidad(soldado);
                   casilleros[posicionSoldadoX][posicionSoldadoY].eliminatUnidad();
                   contador++;
               }catch (CasilleroOcupadoException e){
                   Unidad unidadDeCasillero =casilleros[posicionSoldadoX + distanciaX][posicionSoldadoY + distanciaY].getUnidad();
                   if (listaUnidades.contains(unidadDeCasillero)){
                       listaUnidades.add(soldado);
                   }
               }
           }
       }
   }

   private void moverUnidadSolitaria(int posX, int posY, Casillero[][] casilleros) throws UnidadNulaException, CasilleroOcupadoException, MovimientoInvalidoException {
        casilleros[posX][posY].modificarUnidad(unidad_actual);
        eliminatUnidad();
   }

   private void eliminatUnidad(){
        unidad_actual = unidadNula;
   }

}