import Excepciones.NoAlcanzanLosPuntosException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IniciarJuego {

    Scanner input = new Scanner(System.in);

    public void iniciarJuego() throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {
        System.out.println("Bienvenidos a AlgoChess");
        Jugador jugador1 = crearJugador("Ingrese el nombre del primer Jugador: ");
        Jugador jugador2 = crearJugador("Ingrese el nombre del segundo Jugador: ");
        inicializacionTurnos(jugador1,jugador2);

        // Termina el la inicializacion de las unidades, comienza etapa de jugar.
        JugabilidadJuego comienzoJuego = new JugabilidadJuego();
        comienzoJuego.arrancarJuego(jugador1,jugador2);
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
            System.out.println("Que unidad quiere crear ?.");
            try {
                jugador.crearUnidad(input.nextLine());
            }catch (NoAlcanzanLosPuntosException e){
                System.out.println(e.getMessage());
                System.out.println("Dispone de " + jugador.getPuntos() + "puntos");
            }
        } while (jugador.puedeSeguirColocandoFichas());
    }
}
