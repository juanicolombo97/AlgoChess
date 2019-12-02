package fiuba.algo3.algochess.Vista;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InterfazJuego {

    public static BorderPane crearInterfaz(Pane tablero, VBox ladoIzq,VBox ladoDer){
        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(tablero);
        BorderPane.setMargin(ladoIzq,new Insets(10));
        BorderPane.setMargin(ladoDer,new Insets(10));
        borderPane.setLeft(ladoIzq);
        borderPane.setRight(ladoDer);

        return borderPane;
    }
}
