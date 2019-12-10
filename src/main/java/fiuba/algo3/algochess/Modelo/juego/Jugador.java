package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.acciones.AccionJugador;
import fiuba.algo3.algochess.Modelo.excepciones.CasilleroEnemigoException;
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

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        puntosJugador = new Puntos(puntosColocacionFichas);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }  //Se usa solo en vista

    public int getPuntosDisponibles() {
        return this.puntosJugador.getPuntosDisponibles();
    } //Se usa en vista y en test

    public void setCasillerosDeJugador(List<Casillero> casilleros) {
        casilleroJugador = casilleros;
    }

    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion, Emisario emisario) {
        //Creo la unidad y cambio los puntos disponibles del jugador
        esCasilleroAliado(casillero);
        UnidadNueva unidadNueva = new UnidadNueva();
        return unidadNueva.crearUnidad(nombreUnidad, puntosJugador, posicion, emisario);
    }

    public void guardarUnidad(Unidad unidadNueva) {
        unidadesDisponibles.add(unidadNueva);
    }

    public void esCasilleroAliado(Casillero casillero){
        if (!casilleroJugador.contains(casillero)){
            throw new CasilleroEnemigoException("El casillero pertenece al enemigo");
        }
    }

    public void modificarPuntos(Unidad unidad) {
        puntosJugador.modificarPuntos(unidad.costoDeUnidad());
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

    public void puedeSeguirColocandoFichas(){
        puntosJugador.puedeSeguirColocandoFichas();
    }

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, Map<Posicion, Casillero> tablero, Distancia distancia) {
       unidadPerteneceAJugador(atacante);
        AccionJugador accion = new AccionJugador();
        boolean esUnidadAliada = esUnidadAliada(atacado);
        //Si la unidad no es una catapulta no puede atacar aliados
        accion.accionNueva(atacante, atacado, tablero, esUnidadAliada, distancia);

    }

    public List<Unidad> unidadesAMover(Unidad unidadAMover, Map<Posicion,Casillero> tablero){
        return unidadAMover.habilidadMoverse(unidadAMover, tablero, unidadesDisponibles);
    }

    public List<Unidad> getUnidadesDisponibles() {
        return unidadesDisponibles;
    } //Se usa solo en test

    public boolean esUnidadAliada(Unidad unidad) {
        return unidadesDisponibles.contains(unidad);
    }

    public void reconocerUnidadesAliadasCercanasAUnidad(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesAliadasCercanasAUnidad) {
        if (esUnidadAliada(unidad)) {
            reconocerUnidadesAliadasAdyacentesAUnidad(unidadesCercanas, unidadesAliadasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesAliadasAdyacentesAUnidad(List<Unidad> unidadesCercanas, List<Unidad> unidadesAliadasCercanasAUnidad) {
        for (Unidad unidadActual : unidadesCercanas) {
            if (esUnidadAliada(unidadActual)) {
                unidadesAliadasCercanasAUnidad.add(unidadActual);
            }
        }
    }

    public void reconocerUnidadesEnemigasCercanasA(Unidad unidad, List<Unidad> unidadesCercanas, List<Unidad> unidadesEnemigasCercanasAUnidad) {
        if (esUnidadAliada(unidad)) {
            reconocerUnidadesEnemigasAdyacentesAUnidad(unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesEnemigasAdyacentesAUnidad(List<Unidad> unidadesCercanas, List<Unidad> unidadesEnemigasCercanasAUnidad) {
        for (Unidad unidadActual : unidadesCercanas) {
            if (!esUnidadAliada(unidadActual)) {
                unidadesEnemigasCercanasAUnidad.add(unidadActual);
            }
        }
    }

    public void verificarSiPuedeSeguirJugando() {
        if (unidadesDisponibles.size() == 0){
            throw new JugadorPerdioException("El jugador perdio");
        }
    }

    public void actualizarUnidadesDisponibles() {
        ArrayList<Unidad> listaUnidadesVivas = new ArrayList<>();
        for (Unidad unidad : unidadesDisponibles){
            unidad.sigueViva(listaUnidadesVivas);
        }
        unidadesDisponibles =  listaUnidadesVivas;
    }
}
