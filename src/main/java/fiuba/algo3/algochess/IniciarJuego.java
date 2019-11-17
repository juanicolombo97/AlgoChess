package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IniciarJuego {

    Scanner input = new Scanner(System.in);

    public void iniciarJuego() throws UnidadInvalidaException, NoAlcanzanLosPuntosException, NoPuedeAtacarException, CurarException, CasilleroOcupadoException {
        System.out.println("Bienvenidos a AlgoChess\n\n");
        Jugador jugador1 = crearJugador("Ingrese el nombre del primer fiuba.algochess.Jugador: ");
        Jugador jugador2 = crearJugador("Ingrese el nombre del segundo fiuba.algochess.Jugador: ");

        Tablero tablero = new Tablero(jugador1,jugador2);
        inicializacionTurnos(jugador1,jugador2,tablero);
        System.out.println("Comienzan los turnos, arranca: " + jugador1.getNombre());
        accionesJuego(jugador1,jugador2,tablero);
        if (jugador1.puedeSeguirJugando()){
            System.out.println("Felicitaciones " + jugador1.getNombre() + " has ganado");
            return;
        }
        System.out.println("Felicitaciones " + jugador2.getNombre() + " has ganado");

    }
        //Crea los jugadores del juego.
    public Jugador crearJugador(String msg) {
        // Pido al usuario el nombre y devuelvo el fiuba.algochess.Jugador.


        System.out.println(msg);
        String nombreJugador = input.nextLine();
        System.out.println("Hola " + nombreJugador + "\n");
        return new Jugador(nombreJugador);
    }

        // Decide quien arranca el juego.
    public void inicializacionTurnos(Jugador jugador1, Jugador jugador2,Tablero tablero) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
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

    public void colocarFichas(Jugador jugador,Tablero tablero) throws UnidadInvalidaException, NoAlcanzanLosPuntosException {

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
            }catch (UnidadInvalidaException | CasilleroEnemigoException | CasilleroOcupadoException e){
                System.out.println(e.getMessage()+ ",eliga una unidad correcta.");
            }
        } while (jugador.getPuntos() != 0);
    }

    private void accionesJuego(Jugador jugador1 ,Jugador jugador2,Tablero tablero) throws NoPuedeAtacarException, CurarException, CasilleroOcupadoException {
        while (jugador1.puedeSeguirJugando() && jugador2.puedeSeguirJugando()){
            realizarJugadas(jugador1,jugador2,tablero);
            realizarJugadas(jugador2,jugador1,tablero);
        }

    }

    private void realizarJugadas(Jugador jugador1, Jugador jugador2, Tablero tablero) throws NoPuedeAtacarException, CurarException, CasilleroOcupadoException {
        System.out.println("Turno de " + jugador1.getNombre() + " desea atacar, mover o curar una unidad");
        String accionJugador = input.next();
        if (accionJugador.equalsIgnoreCase("atacar")){
            jugadaAtacar(jugador1,jugador2,tablero);
        }
        if (accionJugador.equalsIgnoreCase("mover")){
            jugadaMover(jugador1,jugador2,tablero);
        }
        else if (accionJugador.equalsIgnoreCase("curar")){
            jugadaCurar(jugador1);
        }
    }

    private void jugadaAtacar(Jugador jugador1, Jugador jugador2, Tablero tablero) throws NoPuedeAtacarException, CurarException, CasilleroOcupadoException {
        System.out.println(jugador1.getNombre() + " elija una unidad para atacar");
        System.out.println(jugador1.unidadesDisponibles());
        Unidad unidadAtacante = (Unidad) jugador1.unidadesDisponibles().get(input.nextInt());
        System.out.println("Elija una unidad a atacar");
        System.out.println(jugador2.unidadesDisponibles());
        Unidad unidadAAtacar = (Unidad) jugador2.unidadesDisponibles().get(input.nextInt());
        try {
            jugador1.atacar(unidadAtacante, unidadAAtacar);
        }catch (NoPuedeAtacarException | CurarException e){
            System.out.println(e.getMessage());
            realizarJugadas(jugador1,jugador2,tablero);
        }
    }

    private void jugadaMover(Jugador jugador1,Jugador jugador2,Tablero tablero) throws CasilleroOcupadoException, NoPuedeAtacarException, CurarException {
        System.out.println(jugador1.getNombre() + "elija una unidad para mover");
        System.out.println(jugador1.unidadesDisponibles());
        Unidad unidadAMover = (Unidad) jugador1.unidadesDisponibles().get(input.nextInt());
        System.out.println("A que posicion X desea moverla");
        int movimientoX = input.nextInt();
        System.out.println("A que posicion en Y desea moverla");
        int movimientoY = input.nextInt();
        try {
            tablero.moverUnidad(unidadAMover.posicionEnX(), unidadAMover.posicionEnY(), movimientoX, movimientoY);
        }catch (CasilleroOcupadoException e){
            System.out.println(e.getMessage());
            realizarJugadas(jugador1,jugador2,tablero);
        }
    }

    private void jugadaCurar(Jugador jugador){
        System.out.println("Seleccione curandero");
        System.out.println(jugador.unidadesDisponibles());
        Unidad unidadCurandero = (Unidad) jugador.unidadesDisponibles().get(input.nextInt());
        System.out.println("Seleccione unidad a curar");
        Unidad unidadACurar = (Unidad) jugador.unidadesDisponibles().get(input.nextInt());
        try {
            jugador.atacar(unidadCurandero,unidadACurar);
        } catch (CurarException | NoPuedeAtacarException e) {
            System.out.println(e.getMessage());
        }
    }
}

