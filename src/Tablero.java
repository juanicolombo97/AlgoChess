import Excepciones.*;

public class Tablero {
    private Casillero[][] arrayCasillero;
    private UnidadNueva unidad = new UnidadNueva();

    public Tablero(Jugador jugador1, Jugador jugador2) throws excepciones.UnidadInvalidaException, CasilleroOcupadoExcenption {
        this.arrayCasillero = new Casillero[21][21];
        for(int i = 1; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Casillero casillero = this.asignarEquipo(i, j,jugador1,jugador2);
                this.arrayCasillero[i][j] = casillero;
            }
        }
    }

    private Casillero asignarEquipo (int i, int j,Jugador jugador1, Jugador jugador2) throws excepciones.UnidadInvalidaException {
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

    public void crearUnidad(Jugador jugador, int posicionX, int posicionY, String nombreUnidad) throws NoAlcanzanLosPuntosException, excepciones.UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoExcenption {
        Casillero casillero = arrayCasillero[posicionX][posicionY];
        Unidad unidadCreada = jugador.crearUnidad(posicionX,posicionY,casillero,nombreUnidad);
        casillero.modificarUnidad(unidadCreada);
    }

    public void moverUnidad(int posicionInicialX, int posicionInicialY, int posicionFinalX, int posicionFinalY,Jugador jugador) throws UnidadNulaException, excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoExcenption {
        Unidad unidadAMover = arrayCasillero[posicionInicialX][posicionInicialY].getUnidad();

        //verifico que el casillero no este ocupado
        arrayCasillero[posicionFinalX][posicionFinalY].modificarUnidad(unidadAMover);

        jugador.moverUnidad(unidadAMover,posicionFinalX,posicionFinalY);

    }

    public void atacar(int posicionAtacanteX, int posicionAtacanteY, int posicionAtacadoX, int posicionAtacadoY,Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException {
        Unidad unidadAtacante = arrayCasillero[posicionAtacanteX][posicionAtacanteY].getUnidad();
        Unidad unidadAtacada = arrayCasillero[posicionAtacadoX][posicionAtacadoY].getUnidad();

        jugador.atacar(unidadAtacante,unidadAtacada);
    }
}
