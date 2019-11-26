package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.acciones.AccionJugador;
import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.unidades.Catapulta;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNueva;
import fiuba.algo3.algochess.unidades.UnidadNula;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList();
    public ArrayList casilleroJugador = new ArrayList();
    private UnidadNueva unidadNueva = new UnidadNueva();
    private UnidadNula unidadNula = new UnidadNula(0,0);
    private Catapulta catapultaAtacarAliado = new Catapulta(0,0);
    private String nombreJugador;

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
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

    Unidad crearUnidad(int posicionX, int posicionY, Casillero casillero, String nombreUnidad) throws CasilleroEnemigoException, UnidadInvalidaException, NoAlcanzanLosPuntosException {

        //Llamo para ver si el casillero pertenece al jugador
        casilleroAliado(casillero);
        disponeDePuntos();

        //Creo la unidad y cambio los puntos disponibles del jugador
        Unidad unidadCreada = unidadNueva.crearUnidad(nombreUnidad,posicionX,posicionY);
        modificarPuntos(unidadCreada);
        unidadesDisponibles.add(unidadCreada);

        return unidadCreada;
    }

    private void disponeDePuntos() throws NoAlcanzanLosPuntosException {
        if (puntosColocacionFichas <= 0){
            throw new NoAlcanzanLosPuntosException("Puntos no disponibles");
        }
    }

    private void modificarPuntos(Unidad unidad) {
        puntosColocacionFichas -= unidad.cuantoCuesta();
    }

    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() !=0;
    }

    public void moverUnidad(Unidad unidadAMover, int posX, int posY) throws UnidadInvalidaException, UnidadNulaException, MovimientoInvalidoException {
        // verifico que pertenesca al jugador la unidad
        unidadPerteneceAJugador(unidadAMover,false,"La unidad pertenece al enemigo");

        unidadAMover.moverUnidad(posX,posY);
    }

    private void unidadPerteneceAJugador(Unidad unidad, boolean pertenece, String mensajeError) throws UnidadInvalidaException {
        if ( pertenece ==unidadesDisponibles.contains(unidad) && !unidad.getClass().equals(unidadNula.getClass())){
            throw new UnidadInvalidaException(mensajeError);
        }
    }

    public void atacar(Unidad atacante, Unidad atacado, Casillero casillero, Casillero[][] arrayCasillero) throws CurarException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        AccionJugador accion = new AccionJugador();

        //Si la unidad no es una catapulta no puede atacar aliados
        if (!atacante.getClass().equals(catapultaAtacarAliado.getClass())){
            unidadPerteneceAJugador(atacado,true,"La unidad es aliada");
        }
        if (casilleroJugador.contains(casillero)){
            accion.accionNueva(atacante,atacado,0.05,arrayCasillero);
        }else{
            accion.accionNueva(atacante,atacado,0, arrayCasillero);
        }

    }

    public ArrayList getUnidadesDisponibles(){
        return unidadesDisponibles;
    }


    public boolean unidadAliada(Unidad unidad){
        return unidadesDisponibles.contains(unidad);
    }
}
