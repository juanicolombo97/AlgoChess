package interfaz;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TurnoDeVentana {

    static boolean respuesta;

    public static boolean display(String titulo, String mensaje) {
        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);

        Label label = new Label();
        label.setText(mensaje);


        VBox layout = new VBox(10);
        Scene scene = new Scene(layout);

        layout.getChildren().add(label);
        layout.setAlignment(Pos.CENTER);

        ventana.setScene(scene);
        ventana.showAndWait();


        return respuesta;
    }
}
