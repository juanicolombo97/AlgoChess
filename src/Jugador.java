import Excepciones.CurarException;
import Excepciones.NoAlcanzanLosPuntosException;
import Excepciones.NoPuedeAtacarException;
import excepciones.UnidadInvalidaException;

import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {

    private int puntosColocacionFichas = 20;
    private ArrayList<Unidades> unidadesDisponibles = new ArrayList();
    private String nombre;
    private int puntosDisponiblesParaJugar = 20;

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
    void crearUnidad(int posicionX, int posicionY, String unidad) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        UnidadNueva unidadNueva = new UnidadNueva();
        Unidades unidadCreada = unidadNueva.crearUnidad(unidad,posicionX,posicionY);

        // Me fijo que no se exceda de los puntos.
        try {
            puntosSuficientes(unidadCreada.cuantoCuesta());
            agregarUnidad(unidadCreada);
        } catch (Exception e) {
            throw new NoAlcanzanLosPuntosException("Puntos insuficientes");
        }
    }
    // Funcion para atacar unidades.
    public void atacar(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        AccionJugador accionJugador = new AccionJugador();
        accionJugador.accionNueva(atacante,atacado);
    }

    //Devuelve true si el jugador posee unidades.
    public boolean puedeSeguirJugando(){
        revisionUnidades();
        return unidadesDisponibles.size() != 0;
    }
    //Lanza error si no alcanzan los puntos para crear ficha.
    private void puntosSuficientes(int costoUnidad) throws Exception {
        if(puntosColocacionFichas - costoUnidad < 0){
            throw new Exception();
        }
    }

    //Agrega una unidad a la lista de unidades
    private void agregarUnidad(Unidades unidad){
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
        return unidadesDisponibles;
    }

}
