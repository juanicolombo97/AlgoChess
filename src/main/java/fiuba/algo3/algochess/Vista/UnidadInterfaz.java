package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import javafx.scene.paint.Color;

import javafx.scene.control.Label;

public class UnidadInterfaz extends Pane {

    private Unidad unidad;
    private Posicion posicion;

    public UnidadInterfaz(Unidad unidad, boolean color, String nombreUnidad){
        this.unidad = unidad;
        posicion = unidad.getPosicion();
        Label nombre = new Label(nombreUnidad);

        if (color){
            setStyle("-fx-background-color: #000000");
            nombre.setTextFill(Color.WHITE);
            setBorder(new Border(new BorderStroke(Color.YELLOW,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }else {
            setStyle("-fx-background-color: #e7e7e7");
            setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }

        relocate(posicion.posicionX * TableroInterfaz.tamanioCasillero, posicion.posicionY * TableroInterfaz.tamanioCasillero);

        getChildren().add(nombre);
    }

}
