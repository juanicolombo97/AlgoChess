import Excepciones.*;
import excepciones.UnidadInvalidaException;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList();
    private Hashtable casilleroJugador = new Hashtable();
    private UnidadNueva unidadNueva = new UnidadNueva();

    public void agregarCasillero(Casillero casilleroNuevo){
        casilleroJugador.put(casilleroNuevo,casilleroNuevo.getUnidad());
    }

    public void casilleroAliado(Casillero casillero) throws CasilleroEnemigoException {
        if (!casilleroJugador.containsKey(casillero)){
            throw new CasilleroEnemigoException("El casillero pertenece al enemigo");
        }
    }

    public Unidad crearUnidad(int posicionX,int posicionY, Casillero casillero,String nombreUnidad) throws CasilleroEnemigoException, UnidadInvalidaException, NoAlcanzanLosPuntosException {

        //Llamo para ver si el casillero pertenece al jugador
        casilleroAliado(casillero);
        disponeDePuntos();

        //Creo la unidad y cambio los puntos disponibles del jugador
        Unidad unidadCreada = unidadNueva.crearUnidad(nombreUnidad,posicionX,posicionY);
        modificarPuntos(unidadCreada);
        unidadesDisponibles.add(unidadCreada);

        return unidadCreada;
    }

    public void disponeDePuntos() throws NoAlcanzanLosPuntosException {
        if (puntosColocacionFichas <= 0){
            throw new NoAlcanzanLosPuntosException("Puntos no disponibles");
        }
    }

    public void modificarPuntos(Unidad unidad) {
        puntosColocacionFichas -= unidad.cuantoCuesta();
    }

    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() !=0;
    }

    public void moverUnidad(Unidad unidadAMover, int posX, int posY) throws UnidadInvalidaException, UnidadNulaException, MovimientoInvalidoException {
        // verifico que pertenesca al jugador la unidad
        unidadPerteneceAJugador(unidadAMover);

        unidadAMover.moverUnidad(posX,posY);
    }

    public void unidadPerteneceAJugador(Unidad unidad) throws UnidadInvalidaException {
        if (!unidadesDisponibles.contains(unidad)){
            throw new UnidadInvalidaException("La unidad pertenece al enemigo");
        }
    }

    public void atacar(Unidad atacante, Unidad atacado) throws CurarException, UnidadNulaException, NoPuedeAtacarException {
        AccionJugador accion = new AccionJugador();

        accion.accionNueva(atacante,atacado);
    }
}
