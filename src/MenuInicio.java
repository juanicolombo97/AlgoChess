import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuInicio extends Application {

    Button boton;
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Configuro el nombre de la app y los componentes principales
        primaryStage.setTitle("AlgoChess");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300,250);

        //Configuro boton.
        boton = new Button("Iniciar Juego");
        // Creo imagen y la establesco para que se mueva con la app.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());

        //Agrego las cosas a la primaryStage.
        layout.getChildren().add(imagen);
        layout.getChildren().add(boton);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
