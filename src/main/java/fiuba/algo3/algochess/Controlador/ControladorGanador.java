package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Vista.FaseJuego;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorGanador {


    public ControladorGanador(FaseJuego faseJuego,String ganador) {
        Stage ventana = new Stage();
        ventana.setTitle("Ganador");
        ventana.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(8);
        pane.setHgap(10);

        Label usuario = new Label(ganador);
        pane.getChildren().add(usuario);


        Scene scene = new Scene(pane);
        ventana.setScene(scene);
        ventana.show();

        ventana.setOnCloseRequest( e -> {
            ventana.close();
            faseJuego.cerrarJuego();
        });
    }
}
