package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.acciones.AccionJugador;
import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.unidades.*;

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

    private void casilleroAliado(Casillero casillero){
        if (!casilleroJugador.contains(casillero)){
            throw new CasilleroEnemigoException("El casillero pertenece al enemigo");
        }
    }

    public Unidad crearUnidad(Casillero casillero, String nombreUnidad, Posicion posicion, Emisario emisario) {

        //Llamo para ver si el casillero pertenece al jugador.
        casilleroAliado(casillero);
        //Creo la unidad y cambio los puntos disponibles del jugador
        UnidadNueva unidadNueva = new UnidadNueva();
        Unidad unidadCreada = unidadNueva.crearUnidad(nombreUnidad,puntosJugador,posicion,emisario);
        return unidadCreada;
    }

    public void guardarUnidad(Unidad unidadNueva) {
        unidadesDisponibles.add(unidadNueva);
    }

    public void modificarPuntos(Unidad unidad) {
        puntosJugador.puntosSuficientes(unidad.cuantoCuesta());
    }

    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() !=0;
    }

    public void unidadPerteneceAJugador(Unidad unidad) {
        if (!unidadesDisponibles.contains(unidad)){
            throw new UnidadInvalidaException("Unidad pertenece al enemigo");
        }
    }

    public void unidadModificarPosicionCasillero(Unidad unidad, Casillero casilleroFin){
        if (casilleroJugador.contains(casilleroFin)){
            unidad.enCasilleroAliado();
        }else {
            unidad.enCasilleroEnemigo();
        }
    }

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, HashMap tablero, Distancia distancia) {
        AccionJugador accion = new AccionJugador();
        boolean esUnidadAliada = unidadAliada(atacado);
        //Si la unidad no es una catapulta no puede atacar aliados
        accion.accionNueva(atacante,atacado,tablero,esUnidadAliada,distancia);
    }

    public ArrayList<Unidad> getUnidadesDisponibles(){
        return unidadesDisponibles;
    }

    public boolean unidadAliada(Unidad unidad){
        return unidadesDisponibles.contains(unidad);
    }

    public int getPuntosDisponibles(){
        return puntosJugador.puntosDisponibles;
    }

    public void reconocerUnidadesAliadasCercanasA(Unidad unidad, ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanasAUnidad) {
        if (unidadAliada(unidad)){
            reconocerUnidadesAliadasAdyascentesAUnidad(unidadesCercanas,unidadesAliadasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesAliadasAdyascentesAUnidad(ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanasAUnidad) {
        for(int i = 0; i < unidadesCercanas.size(); i++) {
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            if (unidadAliada(unidadActual)) {
                unidadesAliadasCercanasAUnidad.add(unidadActual);
            }
        }
    }

    public void reconocerUnidadesEnemigasCercanasA(Unidad unidad, ArrayList unidadesCercanas, ArrayList unidadesEnemigasCercanasAUnidad) {
        if (unidadAliada(unidad)){
            reconocerUnidadesEnemigasAdyascentesAUnidad(unidadesCercanas,unidadesEnemigasCercanasAUnidad);
        }
    }

    private void reconocerUnidadesEnemigasAdyascentesAUnidad(ArrayList unidadesCercanas, ArrayList unidadesEnemigasCercanasAUnidad) {
        for(int i = 0; i < unidadesCercanas.size(); i++) {
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            if (!unidadAliada(unidadActual)) {
                unidadesEnemigasCercanasAUnidad.add(unidadActual);
            }
        }
    }
}
