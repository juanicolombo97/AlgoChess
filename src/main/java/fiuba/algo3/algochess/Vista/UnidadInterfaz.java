package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

import java.io.File;

public class UnidadInterfaz extends StackPane {

    private Unidad unidad;
    public  Posicion posicion;
    private int tamanioCasillero;
    private TableroInterfaz tableroInterfaz;
    private final ImageView imagen;
    public String nombre;

    public UnidadInterfaz(Unidad unidad, boolean color, String nombreUnidad, FaseJuego juego, String imagenAliada, String imagenEnemiga, String audio){
        Media media = new Media(new File(audio).toURI().toString());
        MediaPlayer ruidoUnidad = new MediaPlayer(media);
        ruidoUnidad.play();
        this.unidad = unidad;
        this.nombre = nombreUnidad;
        posicion = unidad.getPosicion();
        this.tableroInterfaz = juego.tableroInterfaz;
        this.tamanioCasillero = tableroInterfaz.tamanioCasillero;
        setWidth(tamanioCasillero);
        setHeight(tamanioCasillero);

        Label nombre = new Label(nombreUnidad);
        nombre.setMaxWidth(tamanioCasillero);
        nombre.setMaxHeight(tamanioCasillero);

        if (color){
           imagen  = new ImageView(imagenAliada);
        }else {
            imagen = new ImageView(imagenEnemiga);
        }
            setOnMouseClicked(unidadPresionada -> {
                if (juego.comenzoElJuego()) {
                    juego.cambiarJugadorActual(juego.juego.jugadorActual().getNombreJugador());
                    juego.cambiarVidaUnidad(unidad.getVidaUnidad());
                    juego.cambiarNombreUnidad(nombreUnidad);
                }
            });

        imagen.setFitHeight(tamanioCasillero);
        imagen.setFitWidth(tamanioCasillero);
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        getChildren().add(imagen);
    }



    public Unidad getUnidad(){
        return unidad;
    }

    public void modificarPosicion(){
        posicion = unidad.getPosicion();
    }
}
