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
    //Crea una unidad
    public void crearUnidad(int posicionX,int posicionY, String unidad) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
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

    public void atacar(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        AccionJugador accionJugador = new AccionJugador();
        accionJugador.accionNueva(atacante,atacado);
    }

    public boolean puedeSeguirJugando(){
        return unidadesDisponibles.size() != 0;
    }

    private void puntosSuficientes(int costoUnidad) throws Exception {
        if(puntosDisponiblesParaJugar - costoUnidad < 0){
            throw new Exception();
        }
    }
    private void agregarUnidad(Unidades unidad){
        unidadesDisponibles.add(unidad);
        restarPuntos(unidad.cuantoCuesta());
    }

    private void restarPuntos(int costoUnidad){
        puntosColocacionFichas -= costoUnidad;
    }

    public void revisionUnidades(){
        for (int iterador = 0; iterador< unidadesDisponibles.size(); iterador++){
            //Si la unidad no esta viva la elimino
            if (!(unidadesDisponibles.get(iterador).estaVivo())){
                unidadesDisponibles.remove(iterador);
            }
        }
    }

}
