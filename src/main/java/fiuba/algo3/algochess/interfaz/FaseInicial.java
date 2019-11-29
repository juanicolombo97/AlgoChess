package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class FaseInicial {
    public static int tamanioCasillero = 25;
    public static int filas = 20;
    public static int columnas = 20;
    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private static Group grupoCasilleros = new Group();

    public static void display() throws CasilleroOcupadoException, UnidadInvalidaException {
        //Inicializo Jugadores
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 1")));
        listaJugadores.add(new Jugador(VentanaLoguear.display("Registro Jugador 2")));

        Tablero tablero = new Tablero(listaJugadores.get(0),listaJugadores.get(1));
        Pane pane = crearTablero(tablero.getTablero());
        inicializarFaseCreacionFichas(tablero,pane);

    }

    public static void inicializarFaseCreacionFichas(Tablero tablero,Pane pane){
        Stage ventana = new Stage();
        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(pane);

        Scene scene = new Scene(borderPane,800,800);
        ventana.setScene(scene);
        ventana.show();
    }

    public static Pane crearTablero(HashMap casilleros){
        Pane pane = new Pane();
        pane.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        for (Object casillero : casilleros.values()){
            CasilleroInterfaz casilleroNuevo = new CasilleroInterfaz((Casillero) casillero);
            grupoCasilleros.getChildren().add(casilleroNuevo);
        }
        pane.getChildren().add(grupoCasilleros);
        return pane;
    }
}
