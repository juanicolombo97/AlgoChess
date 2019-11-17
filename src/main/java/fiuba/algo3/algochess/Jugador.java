package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList();
    private String nombre;
    private int puntosDisponiblesParaJugar = 20;
    private Hashtable casilleroJugador = new Hashtable();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntos(){
        return puntosColocacionFichas;
    }

    //Crea una unidad
    public void crearUnidad(int posicionX, int posicionY, String unidad,Casillero casillero) throws UnidadInvalidaException, NoAlcanzanLosPuntosException, CasilleroEnemigoException, CasilleroOcupadoException {
        UnidadNueva unidadNueva = new UnidadNueva();
        Unidad unidadCreada = unidadNueva.crearUnidad(unidad,posicionX,posicionY);
        //Me fijo si el casillero pertenece al jugador y sino agrego la unidad.

        casilleroPertenceAJugador(casillero);
        casillero.recibir_unidad(unidadCreada);
        // Me fijo que no se exceda de los puntos.
        try {
            casilleroPertenceAJugador(casillero);
            puntosSuficientes(unidadCreada.cuantoCuesta());
            agregarUnidad(unidadCreada);
        } catch (Exception e) {
            throw new NoAlcanzanLosPuntosException("Puntos insuficientes");
        }
    }

    // Funcion para atacar unidades.
    public void atacar(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException {
        AccionJugador accionJugador = new AccionJugador();
        accionJugador.accionNueva(atacante,atacado);

    }

    //Devuelve true si el jugador posee unidades.
    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() != 0;
    }
    //Lanza error si no alcanzan los puntos para crear ficha.
    private void puntosSuficientes(int costoUnidad) throws Exception {
        if(puntosColocacionFichas - costoUnidad < 0){
            throw new Exception();
        }
    }

    //Agrega una unidad a la lista de unidades
    private void agregarUnidad(Unidad unidad){
        unidadesDisponibles.add(unidad);
        restarPuntos(unidad.cuantoCuesta());
    }

    //Resta los puntos al crear una unidad.
    private void restarPuntos(int costoUnidad){
        puntosColocacionFichas -= costoUnidad;
    }

    //Se fija si alguna unidad no tiene vida y en ese caso la elimina de la lista.
    public void revisionUnidades(){
        for (int iterador = 0; iterador< unidadesDisponibles.size(); iterador++){
            //Si la unidad no esta viva la elimino
            if (!(unidadesDisponibles.get(iterador).estaVivo())){
                unidadesDisponibles.remove(iterador);
            }
        }
    }

    //Devuelve una lista de las unidades que dispone el jugador.
    public ArrayList unidadesDisponibles(){
        revisionUnidades();
        return unidadesDisponibles;
    }

    //Agrega un casillero a los casilleros pertenecientes al jugador.
    public void agregarCasillero(Casillero casillero){
        casilleroJugador.put(casillero,casillero);
    }

    // Se fija si el casillero pertenece al jugador.
    public void casilleroPertenceAJugador(Casillero casillero) throws CasilleroEnemigoException {
        if(!casilleroJugador.containsKey(casillero)){
            throw new CasilleroEnemigoException("Este casillero pertence al enemigo");
        }
    }
}
