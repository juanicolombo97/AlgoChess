package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Controlador.CrearCatapulta;
import fiuba.algo3.algochess.Controlador.CrearCurandero;
import fiuba.algo3.algochess.Controlador.CrearJinete;
import fiuba.algo3.algochess.Controlador.CrearSoldado;
import fiuba.algo3.algochess.Modelo.juego.Jugador;
import fiuba.algo3.algochess.Modelo.juego.Tablero;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TiendaUnidades {

    public static VBox crearUnidades(Jugador jugador, TableroInterfaz tablero, Stage ventana){
        VBox vBox = new VBox(20);

        Label unidades = new Label("Unidades disponibles");
        Button botonSoldado = new Button("Crear Soldado");
        Button botonJinete = new Button("Crear Jinete");
        Button botonCatapulta = new Button("Crear Catapulta");
        Button botonCurandero = new Button("Crear Curandero");
        Button unidadesListas = new Button("Fin colocaccion unidades");

        botonSoldado.setOnAction(e -> CrearSoldado.crear(jugador,tablero));
        botonJinete.setOnAction(e -> CrearJinete.crear(jugador,tablero));
        botonCurandero.setOnAction(e -> CrearCurandero.crear(jugador,tablero));
        botonCatapulta.setOnAction(e -> CrearCatapulta.crear(jugador,tablero));
        unidadesListas.setOnAction(e -> ventana.close());


        vBox.getChildren().addAll(unidades,botonSoldado,botonCurandero,botonJinete,botonCatapulta,unidadesListas);
        return vBox;
    }
}
