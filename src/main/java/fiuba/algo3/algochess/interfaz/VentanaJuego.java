package fiuba.algo3.algochess.interfaz;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaJuego {

    private static Stage secondStage;

    public static void display(String titulo) {

        //Configuro el nombre del juego y hago la ventana.
        secondStage = new Stage();
        secondStage.setTitle(titulo);
        StackPane layout2 = new StackPane();

        Scene scene = new Scene(layout2, 800,600);

        // Creo imagen y la establesco para que se mueva con la ventana.
        final ImageView imagen = new ImageView("imagenes/fondomenu.jpg");
        imagen.fitHeightProperty().bind(scene.heightProperty());
        imagen.fitWidthProperty().bind(scene.widthProperty());

        //Agrego las imagen y botones ala primaryStage.
        layout2.getChildren().add(imagen);
        secondStage.setOnCloseRequest( e -> {
            e.consume();
            cerrarPrograma();

        });

        secondStage.setScene(scene);
        secondStage.setFullScreen(true);
        secondStage.show();


    }

    private static void cerrarPrograma() {
        boolean respuesta = DeseaSalirAlerta.display("AlgoChess","Seguro quiere salir?");
        if(respuesta){secondStage.close();}
    }
}
