import Excepciones.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Tablero {
    private Hashtable tableros = new Hashtable();
    private UnidadNueva unidad = new UnidadNueva();
    private Batallon batallon = new Batallon();
    private ArrayList unidadesBatallon;

    Tablero(Jugador jugador1, Jugador jugador2) throws excepciones.UnidadInvalidaException, CasilleroOcupadoException {
        this.tableros.put(jugador1, new Casillero[21][11]);
        this.tableros.put(jugador2, new Casillero[21][11]);
        asignarCasillerosAJugador(jugador1);
        asignarCasillerosAJugador(jugador2);
    }

    private void asignarCasillerosAJugador (Jugador jugador) throws excepciones.UnidadInvalidaException {
        Casillero[][] casillerosJugador = (Casillero[][]) this.tableros.get(jugador));
        for(int i = 1; i < 21; i++) {
            for (int j = 1; j < 11; j++) {
                Casillero casillero = new Casillero();
                casillero.guardarUnidad(unidad.crearUnidad("", i, j));
                jugador.agregarCasillero(casillero);
                casillerosJugador[i][j] = casillero;
            }
        }
    }

    void crearUnidad(Jugador jugador, int posicionX, int posicionY, String nombreUnidad) throws NoAlcanzanLosPuntosException, excepciones.UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Casillero casillero = arrayCasillero[posicionX][posicionY];
        Unidad unidadCreada = jugador.crearUnidad(posicionX,posicionY,casillero,nombreUnidad);
        casillero.modificarUnidad(unidadCreada);
    }

    public void moverUnidad(int posicionInicialX, int posicionInicialY, int posicionFinalX, int posicionFinalY,Jugador jugador) throws UnidadNulaException, excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException {
        unidadesBatallon =batallon.moverBatallon(arrayCasillero,posicionInicialX,posicionInicialY);
        int distanciaX = posicionFinalX - posicionInicialX;
        int distanciaY = posicionFinalY - posicionInicialY;
        for (int x = 0; x < unidadesBatallon.size(); x++){
            //verifico que el casillero no este ocupado
            Unidad unidadAMover = (Unidad) unidadesBatallon.get(x);

            int posicionUnidadX = unidadAMover.getPosicion().getPosicionX();
            int posicionUnidadY = unidadAMover.getPosicion().getPosicionY();
            int posX = distanciaX + posicionUnidadX;
            int posY = distanciaY + posicionUnidadY;

            arrayCasillero[posicionUnidadX][posicionUnidadY].eliminarUnidad();
            arrayCasillero[posX][posY].modificarUnidad(unidadAMover);
            jugador.moverUnidad(unidadAMover,distanciaX,distanciaY);
        }


    }

    void atacar(int posicionAtacanteX, int posicionAtacanteY, int posicionAtacadoX, int posicionAtacadoY, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, excepciones.UnidadInvalidaException {
        Unidad unidadAtacante = arrayCasillero[posicionAtacanteX][posicionAtacanteY].getUnidad();
        Unidad unidadAtacada = arrayCasillero[posicionAtacadoX][posicionAtacadoY].getUnidad();

        jugador.atacar(unidadAtacante,unidadAtacada,arrayCasillero[posicionAtacadoX][posicionAtacadoY]);
    }

}
