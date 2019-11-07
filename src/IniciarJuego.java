import Excepciones.*;
import excepciones.UnidadInvalidaException;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IniciarJuego {

    Scanner input = new Scanner(System.in);

    public void iniciarJuego() throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException, NoPuedeAtacarException, CurarException {
        System.out.println("Bienvenidos a AlgoChess\n\n");
        Jugador jugador1 = crearJugador("Ingrese el nombre del primer Jugador: ");
        Jugador jugador2 = crearJugador("Ingrese el nombre del segundo Jugador: ");
        Tablero tablero = new Tablero(jugador1,jugador2);
        inicializacionTurnos(jugador1,jugador2,tablero);
        System.out.println("Comienzan los turnos, arranca: " + jugador1.getNombre());
        accionesJuego(jugador1,jugador2,tablero);
    }
        //Crea los jugadores del juego.
    public Jugador crearJugador(String msg) {
        // Pido al usuario el nombre y devuelvo el Jugador.


        System.out.println(msg);
        String nombreJugador = input.nextLine();
        System.out.println("Hola " + nombreJugador + "\n");
        return new Jugador(nombreJugador);
    }

        // Decide quien arranca el juego.
    public void inicializacionTurnos(Jugador jugador1, Jugador jugador2,Tablero tablero) throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);

        Random random = new Random();

        //Este jugador comienza colocando las fichas
        Jugador jugadorQueArranca = listaJugadores.get(random.nextInt(2));
        System.out.println("Comienza colocando las fichas: " + jugadorQueArranca.getNombre()+"\n");

        // Inicia la colocacion de fichas
        listaJugadores.remove(jugadorQueArranca);
        colocarFichas(jugadorQueArranca,tablero);
        System.out.println("Turno de " + listaJugadores.get(0).getNombre()+ "\n");
        colocarFichas(listaJugadores.get(0),tablero);
    }

    public void colocarFichas(Jugador jugador,Tablero tablero) throws excepciones.UnidadInvalidaException, NoAlcanzanLosPuntosException {

        do{
            System.out.println("Que unidad quiere crear ?.\n");
            String nombreJugador = input.next();
            System.out.println("En que posicion X");
            int posX = input.nextInt();
            System.out.println("En que posicion Y");
            int posY = input.nextInt();
            Casillero casillero =new Casillero();
            try {
                tablero.crearUnidad(jugador,nombreJugador,posX,posY);
            }catch (NoAlcanzanLosPuntosException e){
                System.out.println(e.getMessage());
                System.out.println("Dispone de " + jugador.getPuntos() + "puntos");
            }catch (UnidadInvalidaException | CasilleroEnemigoException | CasilleroOcupadoExcenption e){
                System.out.println(e.getMessage()+ ",eliga una unidad correcta.");
            }
        } while (jugador.getPuntos() != 0);
    }

    private void accionesJuego(Jugador jugador1 ,Jugador jugador2,Tablero tablero) throws NoPuedeAtacarException, CurarException {
        while (jugador1.puedeSeguirJugando() && jugador2.puedeSeguirJugando()){
               accionARealizar(jugador1,jugador2,tablero);
           }

    }

    private void accionARealizar(Jugador jugador1, Jugador jugador2,Tablero tablero) throws NoPuedeAtacarException, CurarException {
        System.out.println(jugador1.getNombre() + " desea atacar o mover ficha ?.");
        String accionDelUsuario = input.nextLine();
        if (accionDelUsuario.equalsIgnoreCase("atacar")){
            try {
                System.out.println("Elija una de sus unidades " + jugador1.getNombre());
                System.out.println(jugador1.unidadesDisponibles());
                Unidades unidadeAtacante = (Unidades) jugador1.unidadesDisponibles().get(input.nextInt());
                System.out.println("A que unidad enemiga quiere atacar");
                System.out.println(jugador2.unidadesDisponibles());
                Unidades unidadAtacado = (Unidades) jugador2.unidadesDisponibles().get(input.nextInt());
                jugador1.atacar(unidadeAtacante, unidadAtacado);
            }catch (Exception e){
                System.out.println(e.getMessage());
                accionARealizar(jugador1,jugador2,tablero);
            }
        }
        else if (accionDelUsuario.equalsIgnoreCase("mover")){
            try {
                System.out.println("Elija una unidad a mover");
                System.out.println(jugador1.unidadesDisponibles());
                Unidades unidadAMover = (Unidades) jugador1.unidadesDisponibles().get(input.nextInt());
                System.out.println("A que posicion quiere mover "+ unidadAMover.getNombre() + " en  X");
                int posX = input.nextInt();
                System.out.println("A que posicion quiere mover "+ unidadAMover.getNombre() + " en Y");
                int posY = input.nextInt();
                tablero.moverUnidad(unidadAMover.posicionEnX(),unidadAMover.posicionEnY(),posX,posY);
            }catch (Exception e){
                System.out.println(e.getMessage());
                accionARealizar(jugador1,jugador2,tablero);
            }

        }
    }
}

