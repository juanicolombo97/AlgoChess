package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

import javafx.scene.paint.Color;

    public class UnidadInterfaz extends Pane {

    private Unidad unidad;
    private Posicion posicion;

    public UnidadInterfaz(Unidad unidad,boolean color){
        this.unidad = unidad;
        posicion = unidad.getPosicion();

        if (color){
            setStyle("-fx-background-color: #000000");
            setBorder(new Border(new BorderStroke(Color.YELLOW,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }else {
            setStyle("-fx-background-color: #e7e7e7");
            setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }

        relocate(posicion.getPosicionX() * TableroInterfaz.tamanioCasillero, posicion.getPosicionY() * TableroInterfaz.tamanioCasillero);
        setOnMouseClicked(e -> System.out.println("fefefefe"));
    }

}
