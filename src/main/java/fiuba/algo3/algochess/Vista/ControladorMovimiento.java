package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import javafx.scene.layout.GridPane;

public class ControladorMovimiento {

    private FaseJuego faseJuego;
    private GridPane tablero;
    private Posicion posicionInicial;
    private Posicion posicionFinal;
    

    public ControladorMovimiento(FaseJuego faseJuego, GridPane tablero) {
        this.faseJuego = faseJuego;
        this.tablero = tablero;
        unidadAMover();
    }

    public void unidadAMover(){

        tablero.setOnMouseClicked( mouse1 -> {
            int posicionMouseX = (int) mouse1.getX() / faseJuego.tableroInterfaz.tamanioCasillero;
            int posicionMouseY = (int) mouse1.getY() / faseJuego.tableroInterfaz.tamanioCasillero;
            System.out.println(posicionMouseX + " PRIMERA pos y: " + posicionMouseY);
            posicionInicial = new Posicion(posicionMouseX,posicionMouseY);
            casilleroDestino();
        });

    }

    private void casilleroDestino() {
        tablero.setOnMouseClicked(mouse2 -> {
            int posicionMouseX = (int) mouse2.getX() / faseJuego.tableroInterfaz.tamanioCasillero;
            int posicionMouseY = (int) mouse2.getY() / faseJuego.tableroInterfaz.tamanioCasillero;
            System.out.println(posicionMouseX + " pos y: " + posicionMouseY);
            posicionFinal = new Posicion(posicionMouseX, posicionMouseY);
        });


    }

}
