package interfaz;

import java.util.ArrayList;

public class JugadoresRegistro {

    private static ArrayList jugadores = new ArrayList();

    public void agregarJugador(String jugadorNuevo){
        jugadores.add(jugadorNuevo);
    }

    public String jugardor(int x){
        return (String) jugadores.get(x);
    }
}
