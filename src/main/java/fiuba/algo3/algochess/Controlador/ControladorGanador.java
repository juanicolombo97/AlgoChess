package fiuba.algo3.algochess.Controlador;

import fiuba.algo3.algochess.Vista.FaseJuego;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class ControladorGanador {


    public ControladorGanador(FaseJuego faseJuego,String ganador) {
        Stage ventana = new Stage();
        ventana.setTitle("Ganador");
        ventana.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(8);
        pane.setHgap(10);

        Media media = new Media(new File("src/main/resources/sonidos/victory.mp3").toURI().toString());
        MediaPlayer ruidoGanador = new MediaPlayer(media);
        ruidoGanador.play();
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
