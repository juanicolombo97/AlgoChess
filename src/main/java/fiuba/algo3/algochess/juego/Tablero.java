package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.unidades.Unidad;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private Map<Posicion,Casillero> tablero = new HashMap<>();
    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException, CasilleroOcupadoException {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = this.asignarEquipo(posicion,jugador1,jugador2);
                tablero.put(posicion,casillero);
            }
        }
    }

    private Casillero asignarEquipo (Posicion posicion,Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException {
        if (posicion.getPosicionX()< 10){
            Casillero casillero = new Casillero(posicion);
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero(posicion);
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public Unidad crearUnidad(Jugador jugador,Posicion posicion, String nombreUnidad) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Casillero casilleroDestino = tablero.get(posicion);
        Unidad unidadCreada = jugador.crearUnidad(casilleroDestino,nombreUnidad,posicion);
        casilleroDestino.guardarUnidad(unidadCreada);
        jugador.guardarUnidad(unidadCreada);
        return unidadCreada;
    }

    public void moverUnidad(Posicion posicionInicial,Posicion posicionFinal, Jugador jugador) throws UnidadNulaException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException, CasilleroVacioExcepcion {

        Casillero casilleroInicial = tablero.get(posicionInicial);
        Casillero casilleroDestino = tablero.get(posicionFinal);
        //Veo que la distancia sea correcta.
        casilleroInicial.movimientoValido(casilleroDestino);
        //Verifico que la unidad se peuda mover y que sea del jugador.
        Unidad unidadAMover = casilleroInicial.obtenerUnidad();

        jugador.unidadPerteneceAJugador(unidadAMover);
        unidadAMover.habilidadMoverse();

        casilleroDestino.guardarUnidad(unidadAMover);
        casilleroInicial.eliminarUnidad();
    }

    public void atacar(Posicion posicionAtacante,Posicion posicionAtacado, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, UnidadInvalidaException, CasilleroVacioExcepcion {
        Unidad unidadAtacante = tablero.get(posicionAtacante).obtenerUnidad();
        Unidad unidadAtacada = tablero.get(posicionAtacado).obtenerUnidad();
        Distancia distancia = tablero.get(posicionAtacante).calcularDistancia(posicionAtacado);
        jugador.atacar(unidadAtacante,unidadAtacada,tablero.get(posicionAtacado), (HashMap) tablero, distancia);
    }


}
