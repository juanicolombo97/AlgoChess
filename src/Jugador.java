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
}
