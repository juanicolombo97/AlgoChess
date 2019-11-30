package fiuba.algo3.algochess.Vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TiendaUnidades {

    public static VBox crearUnidades(){
        VBox vBox = new VBox(20);

        Label unidades = new Label("Unidades disponibles");
        Button botonSoldado = new Button("Crear Soldado");
        Button botonJinete = new Button("Crear Jinete");
        Button botonCatapulta = new Button("Crear Catapulta");
        Button botonCurandero = new Button("Crear Curandero");

        botonSoldado.setOnAction(e -> MensajesAJugador.setMensaje("Toque en el tablero para poner unidad"));

        vBox.getChildren().addAll(unidades,botonSoldado,botonCurandero,botonJinete,botonCatapulta);
        return vBox;
    }
}
