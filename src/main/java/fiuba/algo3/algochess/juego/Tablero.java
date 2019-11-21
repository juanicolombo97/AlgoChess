package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNueva;
import fiuba.algo3.algochess.unidades.UnidadNula;

import java.util.ArrayList;

public class Tablero {
    private Casillero[][] arrayCasillero;
    private UnidadNueva unidad = new UnidadNueva();


    public Tablero(Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException, CasilleroOcupadoException {
        this.arrayCasillero = new Casillero[21][21];
        for(int i = 1; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Casillero casillero = this.asignarEquipo(i, j,jugador1,jugador2);
                this.arrayCasillero[i][j] = casillero;
            }
        }
    }

    private Casillero asignarEquipo (int i, int j,Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException {
        if (i <= 10 && j <= 10){
            Casillero casillero = new Casillero();
            casillero.guardarUnidad(unidad.crearUnidad("",i,j));
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero();
            casillero.guardarUnidad(unidad.crearUnidad("",i,j));
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public void crearUnidad(Jugador jugador, int posicionX, int posicionY, String nombreUnidad) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Casillero casillero = arrayCasillero[posicionX][posicionY];
        Unidad unidadCreada = jugador.crearUnidad(posicionX,posicionY,casillero,nombreUnidad);
        casillero.modificarUnidad(unidadCreada);
    }

    public void moverUnidad(int posicionInicialX, int posicionInicialY, int posicionFinalX, int posicionFinalY,Jugador jugador) throws UnidadNulaException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException {

        int distanciaX = posicionFinalX - posicionInicialX;
        int distanciaY = posicionFinalY - posicionInicialY;
        Unidad unidadAMover = arrayCasillero[posicionInicialX][posicionInicialY].getUnidad();

        arrayCasillero[posicionInicialX][posicionInicialY].eliminarUnidad();
        arrayCasillero[posicionFinalX][posicionFinalY].modificarUnidad(unidadAMover);

        jugador.moverUnidad(unidadAMover,distanciaX,distanciaY);


    }

    public void atacar(int posicionAtacanteX, int posicionAtacanteY, int posicionAtacadoX, int posicionAtacadoY, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, UnidadInvalidaException {
        Unidad unidadAtacante = arrayCasillero[posicionAtacanteX][posicionAtacanteY].getUnidad();
        Unidad unidadAtacada = arrayCasillero[posicionAtacadoX][posicionAtacadoY].getUnidad();

        jugador.atacar(unidadAtacante,unidadAtacada,arrayCasillero[posicionAtacadoX][posicionAtacadoY]);
    }

    public ArrayList unidadesCercanas(Unidad unidad){
        ArrayList<Unidad> unidadesCercanasArray = new ArrayList<>();
        Posicion posicionUnidad = unidad.getPosicion();
        Direccion direccion = new Direccion(0,0);
        for(int i = 1; i < direccion.direccionesMovimiento().size(); i++){
            Direccion direccionActual = (Direccion) direccion.direccionesMovimiento().get(i);
            int x = posicionUnidad.getPosicionX() + direccionActual.getX();
            int y = posicionUnidad.getPosicionY() + direccionActual.getY();
            Unidad unidadActual = arrayCasillero[x][y].getUnidad();
            if (unidadActual.getClass().equals(UnidadNula.class)){
                unidadesCercanasArray.add(unidadActual);
            }
        }
        return unidadesCercanasArray;
    }
}
