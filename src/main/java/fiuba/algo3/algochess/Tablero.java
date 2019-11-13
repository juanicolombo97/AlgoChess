package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CasilleroEnemigoException;
import fiuba.algo3.algochess.excepciones.CasilleroOcupadoExcenption;
import fiuba.algo3.algochess.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

public class Tablero {
    private Casillero[][] arrayCasillero;

    public Tablero(Jugador jugador1, Jugador jugador2){
        this.arrayCasillero = new Casillero[21][21];
        for(int i = 1; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Casillero casillero = this.asignarEquipo(i, j,jugador1,jugador2);
                this.arrayCasillero[i][j] = casillero;
            }
        }
    }

    private Casillero asignarEquipo (int i, int j,Jugador jugador1, Jugador jugador2){
        if (i <= 10 && j <= 10){
            Casillero casillero = new Casillero();
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero();
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public void crearUnidad(Jugador jugador,String nombreUnidad,int posX,int posY) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        jugador.crearUnidad(posX,posY,nombreUnidad,arrayCasillero[posX][posY]);

    }

    public Unidad getUnidad(int posX, int posY){
        return arrayCasillero[posX][posY].getUnidad();
    }

    public void moverUnidad(int posXInicial,int posYInicial,int posX,int posY) throws CasilleroOcupadoExcenption {
        arrayCasillero[posXInicial][posYInicial].mover_unidad_a(arrayCasillero[posX][posY],posX,posY);
    }

}
