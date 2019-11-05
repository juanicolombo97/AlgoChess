import Excepciones.CurarCatapultaException;
import Excepciones.NoAlcanzanLosPuntosException;
import Excepciones.NoPuedeAtacarException;
import excepciones.UnidadInvalidaException;

import java.util.HashMap;

public class Jugador {

    private int puntos = 20;
    private HashMap unidadesDisponibles = new HashMap();
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre(){return nombre;}

    public void modificarPuntos(int puntosASacar){
        puntos -= puntosASacar;
    }

    public HashMap getUnidadesCreadas() {
        return unidadesDisponibles;
    }

    public void atacarDistancia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        Acciones accion = new Acciones();
        accion.atacarDistancia(atacante,atacado);
    }

    public void atacarCuerpo(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        Acciones accion = new Acciones();
        accion.atacarCuerpo(atacante,atacado);
    }

    public void curar(Curandero curandero, Unidades unidadACurar) throws CurarCatapultaException {
        Acciones accion = new Acciones();
        accion.curarAUnidad(curandero,unidadACurar);
    }
    public void mover(Unidades unidadAmover){

    }
    public void crearUnidad(String unidadNueva) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        UnidadNueva unidad = new UnidadNueva();
        Unidades unidadCreada = unidad.crearUnidad(unidadNueva);

        //Verifica que alcanzen los puntos
        verificarDisponibilidadDePuntos(unidadCreada);
        //Agrega la unidad
        modificarPuntos(unidadCreada.getCosto());
        unidadesDisponibles.put(unidadCreada,unidadCreada);
    }
    //Devuelve true si tiene puntos y puede seguir poniendo fichas, false caso contrario.
    public boolean puedeSeguirColocandoFichas(){
        return puntos != 0;
    }
        // Verifica que le alcanzen los puntos, caso de no lanza error.
    public void verificarDisponibilidadDePuntos(Unidades unidad) throws NoAlcanzanLosPuntosException {
        if((puntos - unidad.getCosto()) < 0 ){
            throw new NoAlcanzanLosPuntosException("Esta unidad cuesta mas de los puntos que dispone");
        }
    }
}
