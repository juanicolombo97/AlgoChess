package fiuba.algo3.algochess.Vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class DeseaSalirAlerta {

    static boolean respuesta;

    public static boolean display(String titulo, String mensaje) {
        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);

        Label label = new Label();
        label.setText(mensaje);
        Button botonSi = new Button("SI");
        Button botonNo = new Button("No");

        botonSi.setOnAction(e -> {
            respuesta = true;
            ventana.close();
                }
        );
        botonNo.setOnAction(e -> {
            respuesta = false;
            ventana.close();
            }
        );


        VBox layout = new VBox(10);
        Scene scene = new Scene(layout);

        layout.getChildren().addAll(label,botonSi,botonNo);
        layout.setAlignment(Pos.CENTER);

        ventana.setScene(scene);
        ventana.showAndWait();

        return respuesta;
    }
}
