package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.unidades.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList<>();
    public ArrayList<Casillero> casilleroJugador = new ArrayList<>();
    private String nombreJugador;
    private Puntos puntosJugador;

    public Jugador(String  nombreJugador){
        this.nombreJugador = nombreJugador;
        puntosJugador = new Puntos(puntosColocacionFichas);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void agregarCasillero(Casillero casilleroNuevo){
        casilleroJugador.add(casilleroNuevo);
    }

    private void casilleroAliado(Casillero casillero) throws CasilleroEnemigoException {
        if (!casilleroJugador.contains(casillero)){
            throw new CasilleroEnemigoException("El casillero pertenece al enemigo");
        }
    }

    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion) throws CasilleroEnemigoException, UnidadInvalidaException, NoAlcanzanLosPuntosException {

        //Llamo para ver si el casillero pertenece al jugador.
        casilleroAliado(casillero);
        //Creo la unidad y cambio los puntos disponibles del jugador
        UnidadNueva unidadNueva = new UnidadNueva();
        Unidad unidadCreada = unidadNueva.crearUnidad(nombreUnidad,puntosJugador,posicion);
        return unidadCreada;
    }

    public void guardarUnidad(Unidad unidadNueva){
        unidadesDisponibles.add(unidadNueva);
    }

    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() !=0;
    }

    public void unidadPerteneceAJugador(Unidad unidad) throws UnidadInvalidaException {
        if (!unidadesDisponibles.contains(unidad)){
            throw new UnidadInvalidaException("Unidad pertenece al enemigo");
        }
    }

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, HashMap tablero, Distancia distancia) throws CurarException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException, CasilleroVacioExcepcion {
        AccionJugador accion = new AccionJugador();
        boolean esUnidadAliada = unidadAliada(atacado);
        //Si la unidad no es una catapulta no puede atacar aliados
        accion.accionNueva(atacante,atacado,tablero,esUnidadAliada,distancia,tablero);
    }

    public ArrayList<Unidad> getUnidadesDisponibles(){
        return unidadesDisponibles;
    }

    public boolean unidadAliada(Unidad unidad){
        return unidadesDisponibles.contains(unidad);
    }
}
