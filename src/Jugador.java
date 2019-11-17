import Excepciones.*;
import excepciones.UnidadInvalidaException;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidad> unidadesDisponibles = new ArrayList();
    private String nombre;
    private int puntosDisponiblesParaJugar = 20;
    private Hashtable casilleroJugador = new Hashtable();

    public void agregarCasillero(Casillero casilleroNuevo){
        casilleroJugador.put(casilleroNuevo,casilleroNuevo.getUnidad());
    }

    public void casilleroDeJugador() {

    }
}
