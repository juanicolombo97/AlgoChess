package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class UnidadInterfaz extends Pane {

    private  Unidad unidad;
    private  Posicion posicion;

    public UnidadInterfaz(Unidad unidad, boolean color, String nombreUnidad, FaseJuego juego, int tamanioCasillero){

        this.unidad = unidad;
        posicion = unidad.getPosicion();
        setWidth(tamanioCasillero);
        setHeight(tamanioCasillero);

        Label nombre = new Label(nombreUnidad);
        nombre.setMaxWidth(tamanioCasillero);
        nombre.setMaxHeight(tamanioCasillero);

        if (color){
            setStyle("-fx-background-color: #000000");
            nombre.setTextFill(Color.WHITE);
            setBorder(new Border(new BorderStroke(Color.YELLOW,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }else {
            setStyle("-fx-background-color: #e7e7e7");
            setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }
            setOnMouseClicked(unidadPresionada -> {
                if (juego.comenzoElJuego()) {
                    juego.cambiarJugadorActual(juego.juego.jugadorActual().getNombreJugador());
                    juego.cambiarVidaUnidad(unidad.getVidaUnidad());
                }
            });



        getChildren().add(nombre);
    }



    public Unidad getUnidad(){
        return unidad;
    }

}
