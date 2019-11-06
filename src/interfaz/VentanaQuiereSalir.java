package interfaz;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class VentanaQuiereSalir {

    public static void display(String titulo) {

        //Configuro el nombre del juego y hago la ventana.
        Stage secondStage = new Stage();
        secondStage.setTitle(titulo);
        StackPane layout2 = new StackPane();

        Scene scene = new Scene(layout2, 800,600);

        // Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());

        //Agrego las imagen y botones ala primaryStage.
        layout2.getChildren().add(imagen);

        secondStage.setScene(scene);
        secondStage.setFullScreen(true);
        secondStage.show();


    }
}
