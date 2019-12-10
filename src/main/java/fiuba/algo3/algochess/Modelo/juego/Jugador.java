package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.acciones.AccionJugador;
import fiuba.algo3.algochess.Modelo.excepciones.JugadorPerdioException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.Modelo.unidades.Emisario;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import fiuba.algo3.algochess.Modelo.unidades.UnidadNueva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador {
    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList<>();
    public List<Casillero> casilleroJugador = new ArrayList<>();
    private String nombreJugador;
    private Puntos puntosJugador;
    private double DANIOEXTRA = 0.05;
    private double NODANIOEXTRA = 0.00;
    private Jugador jugadorSiguiente;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        puntosJugador = new Puntos(puntosColocacionFichas);
    }



    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntosDisponibles() {
        return this.puntosJugador.getPuntosDisponibles();
    }

    public void casillerosAliados(List<Casillero> casilleros) {
        casilleroJugador = casilleros;
    }


    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion, Emisario emisario) {
        //Creo la unidad y cambio los puntos disponibles del jugador
        UnidadNueva unidadNueva = new UnidadNueva();
        return unidadNueva.crearUnidad(nombreUnidad, puntosJugador, posicion, emisario);
    }

    public void guardarUnidad(Unidad unidadNueva) {
        unidadesDisponibles.add(unidadNueva);
    }

    public void modificarPuntos(Unidad unidad) {
        puntosJugador.puntosSuficientes(unidad.cuantoCuesta());
    }

    public void unidadPerteneceAJugador(Unidad unidad) {
        if (!unidadesDisponibles.contains(unidad)) {
            throw new UnidadInvalidaException("Unidad pertenece al enemigo");
        }
    }

    public void unidadModificarPosicionCasillero(Unidad unidad, Casillero casilleroFin) {
        if (casilleroJugador.contains(casilleroFin)) {
            unidad.setDanioPorCasillero(NODANIOEXTRA);
        } else {
            unidad.setDanioPorCasillero(DANIOEXTRA);
        }
    }

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, Map<Posicion, Casillero> tablero, Distancia distancia) {
        AccionJugador accion = new AccionJugador();
        boolean esUnidadAliada = unidadAliada(atacado);
        //Si la unidad no es una catapulta no puede atacar aliados
        accion.accionNueva(atacante, atacado, tablero, esUnidadAliada, distancia);

    }

    public ArrayList<Unidad> getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public boolean unidadAliada(Unidad unidad) {
        return unidadesDisponibles.contains(unidad);
    }

    public void reconocerUnidadesAliadasCercanasA(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesAliadasCercanasAUnidad) {
        if (unidadAliada(unidad)) {
            reconocerUnidadesAliadasAdyascentesAUnidad(unidadesCercanas, unidadesAliadasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesAliadasAdyascentesAUnidad(List<Unidad> unidadesCercanas, List<Unidad> unidadesAliadasCercanasAUnidad) {
        for (Unidad unidadActual : unidadesCercanas) {
            if (unidadAliada(unidadActual)) {
                unidadesAliadasCercanasAUnidad.add(unidadActual);
            }
        }
    }

    public void reconocerUnidadesEnemigasCercanasA(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesEnemigasCercanasAUnidad) {
        if (unidadAliada(unidad)) {
            reconocerUnidadesEnemigasAdyascentesAUnidad(unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesEnemigasAdyascentesAUnidad(List<Unidad> unidadesCercanas, List<Unidad> unidadesEnemigasCercanasAUnidad) {
        for (Unidad unidadActual : unidadesCercanas) {
            if (!unidadAliada(unidadActual)) {
                unidadesEnemigasCercanasAUnidad.add(unidadActual);
            }
        }
    }

    public void actualizarEstado() {
        puntosJugador.actualizarEstado();
    }

    public void actualizarVidaUnidad(Unidad unidaAtacada, Casillero casilleroUnidad) {
        unidaAtacada.seEncuentraViva(unidadesDisponibles,casilleroUnidad);
    }

    public void puedeSeguirJugando() {
        if (unidadesDisponibles.size() == 0){
            throw new JugadorPerdioException("El jugador perdio");
        }
    }
}
