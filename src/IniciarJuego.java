import Excepciones.CasilleroEnemigoException;
import Excepciones.CasilleroOcupadoExcenption;
import Excepciones.NoAlcanzanLosPuntosException;
import excepciones.UnidadInvalidaException;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IniciarJuego {

    Scanner input = new Scanner(System.in);

    public void iniciarJuego() throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {
        System.out.println("Bienvenidos a AlgoChess");
        Jugador jugador1 = crearJugador("Ingrese el nombre del primer Jugador: ");
        Jugador jugador2 = crearJugador("Ingrese el nombre del segundo Jugador: ");
        Tablero tablero = new Tablero(jugador1,jugador2);
        inicializacionTurnos(jugador1,jugador2);
        movimientoFichas(jugador1,jugador2);
    }
        //Crea los jugadores del juego.
    public Jugador crearJugador(String msg) {
        // Pido al usuario el nombre y devuelvo el Jugador.


        System.out.println(msg);
        String nombreJugador = input.nextLine();
        System.out.println("Hola " + nombreJugador);
        return new Jugador(nombreJugador);
    }

        // Decide quien arranca el juego.
    public void inicializacionTurnos(Jugador jugador1, Jugador jugador2) throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);

        Random random = new Random();

        //Este jugador comienza colocando las fichas
        Jugador jugadorQueArranca = listaJugadores.get(random.nextInt(2));
        System.out.println("Comienza colocando las fichas: " + jugadorQueArranca.getNombre());

        // Inicia la colocacion de fichas
        listaJugadores.remove(jugadorQueArranca);
        colocarFichas(jugadorQueArranca);
        System.out.println("Turno de " + listaJugadores.get(0).getNombre());
        colocarFichas(listaJugadores.get(0));
    }

    public void colocarFichas(Jugador jugador) throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {

        do{
            System.out.println("Que unidad quiere crear ?. [posx,posy,nombre]");
            Casillero casillero =new Casillero();
            try {
                jugador.crearUnidad(input.nextInt(),input.nextInt(),input.nextLine(),casillero);
            }catch (NoAlcanzanLosPuntosException e){
                System.out.println(e.getMessage());
                System.out.println("Dispone de " + jugador.getPuntos() + "puntos");
            }catch (UnidadInvalidaException | CasilleroEnemigoException | CasilleroOcupadoExcenption e){
                System.out.println(e.getMessage()+ ",eliga una unidad correcta.");
            }
        } while (jugador.getPuntos() != 0);
    }

    public void movimientoFichas(Jugador jugador1, Jugador jugador2){
        System.out.println("Comienza el juego. Turno de: " + jugador1.getNombre());
        System.out.println(jugador1.unidadesDisponibles());


    }
}

