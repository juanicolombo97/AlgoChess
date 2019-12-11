package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class UnidadInterfaz extends Pane {

    private Unidad unidad;
    private Posicion posicion;
    private double clickMouseX,clickMouseY;
    private double dragMouseX,dragMouseY;

    public UnidadInterfaz(Unidad unidad, boolean color, String nombreUnidad){
        this.unidad = unidad;
        posicion = unidad.getPosicion();

        mover(posicion.posicionX,posicion.posicionY);

        Label nombre = new Label(nombreUnidad);

        if (color){
            setStyle("-fx-background-color: #000000");
            nombre.setTextFill(Color.WHITE);
            setBorder(new Border(new BorderStroke(Color.YELLOW,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }else {
            setStyle("-fx-background-color: #e7e7e7");
            setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }


        setOnMouseClicked( unidadPresionada -> {
            int x = (int) unidadPresionada.getX() / TableroInterfaz.tamanioCasillero;
            int y = (int) unidadPresionada.getY() / TableroInterfaz.tamanioCasillero;
            System.out.println("pos inicial x: "+posicion.posicionX);
            System.out.println(" presiono en x : " + x);
            System.out.println("pos inicial y: "+posicion.posicionY);
            System.out.println(" presiono en y: " + y);
            FaseJuego.nombreUnidad.setText(nombreUnidad);
            FaseJuego.vidaUnidad.setText("Vida unidad: " + unidad.getVidaUnidad());
        });


        getChildren().add(nombre);
    }

    public void mover(int x, int y){
        dragMouseX = x * TableroInterfaz.tamanioCasillero;
        dragMouseY = y * TableroInterfaz.tamanioCasillero;
        relocate(dragMouseX,dragMouseY);
    }

}
