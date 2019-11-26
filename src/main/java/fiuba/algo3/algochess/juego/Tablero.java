package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.unidades.EmisarioReal;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNueva;
import fiuba.algo3.algochess.unidades.UnidadesCercanas;

import java.util.ArrayList;

public class Tablero {
    private Casillero[][] arrayCasillero;
    private UnidadNueva unidad = new UnidadNueva();
    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException, CasilleroOcupadoException {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
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
            Casillero casillero = new Casillero(i,j);
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero(i,j);
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public void crearUnidad(Jugador jugador, int posicionX, int posicionY, String nombreUnidad) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Casillero casillero = arrayCasillero[posicionX][posicionY];
        EmisarioReal emisario = new EmisarioReal(this);
        Unidad unidadCreada = jugador.crearUnidad(posicionX,posicionY,casillero,nombreUnidad, emisario);
        casillero.guardarUnidad(unidadCreada);
    }

    public void moverUnidad(int posicionInicialX, int posicionInicialY, int posicionFinalX, int posicionFinalY,Jugador jugador) throws UnidadNulaException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException {

        Casillero casilleroInicial = arrayCasillero[posicionInicialX][posicionInicialY];
        Casillero casilleroDestino = arrayCasillero[posicionFinalX][posicionFinalY];
        casilleroInicial.moverUnidad(casilleroDestino,arrayCasillero);
    }

    public void atacar(int posicionAtacanteX, int posicionAtacanteY, int posicionAtacadoX, int posicionAtacadoY, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, UnidadInvalidaException {
        Unidad unidadAtacante = arrayCasillero[posicionAtacanteX][posicionAtacanteY].getUnidad();
        Unidad unidadAtacada = arrayCasillero[posicionAtacadoX][posicionAtacadoY].getUnidad();

        jugador.atacar(unidadAtacante,unidadAtacada,arrayCasillero[posicionAtacadoX][posicionAtacadoY],arrayCasillero);
    }

    public ArrayList unidadesCercanasADistancia1y2(Unidad unaUnidad){
        UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
        ArrayList listaDeUnidades = new ArrayList();
        ArrayList unidadesCercanasADistancia1 = unidadesCercanas.unidadesCercanas(arrayCasillero, listaDeUnidades, unaUnidad, 1);
        ArrayList unidadesCercanasADistancia2 = unidadesCercanas.unidadesCercanas(arrayCasillero, listaDeUnidades, unaUnidad, 2);
        unidadesCercanasADistancia1.addAll(unidadesCercanasADistancia2);
        return unidadesCercanasADistancia1;
    }

    public void notificar(Unidad unidadEmisora) {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidadEmisora);
        for(int i = 1; i < unidadesCercanas.size(); i++){
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            unidadActual.recibirNotificacion();
        }
    }

    public void unidadesAliadasCercanasPorJugador(Unidad unidad, Jugador jugador, ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanas){
        for(int i = 1; i < unidadesCercanas.size(); i++){
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            if (jugador.unidadAliada(unidadActual)){
                unidadesAliadasCercanas.add(unidadActual);
            }
        }
    }

    public ArrayList unidadesAliadasCercanas(Unidad unidad) {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesAliadasCercanasAUnidad = new ArrayList();
        if (this.jugador1.unidadAliada(unidad)){
            unidadesAliadasCercanasPorJugador(unidad, jugador1, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        } else {
            unidadesAliadasCercanasPorJugador(unidad, jugador2, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        }
        return unidadesAliadasCercanasAUnidad;
    }

    public ArrayList unidadesEnemigasCercanas(Unidad unidad) {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesEnemigasCercanasAUnidad = new ArrayList();
        if (this.jugador1.unidadAliada(unidad)){
            unidadesAliadasCercanasPorJugador(unidad, jugador2, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        } else {
            unidadesAliadasCercanasPorJugador(unidad, jugador1, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        }
        return unidadesEnemigasCercanasAUnidad;
    }


}
