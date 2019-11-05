import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;


public class MenuInicio extends Application {

    Button boton;
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Configuro el nombre de la app.
        primaryStage.setTitle("AlgoChess");

        //Configuro boton.
        boton = new Button("Iniciar Juego");

        StackPane layout = new StackPane();
        layout.getChildren().add(boton);

        Scene scene = new Scene(layout, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
