package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroInterfaz extends StackPane {

    private Casillero casillero;
    private UnidadInterfaz unidad;
    private boolean casilleroAliado = false;


    public CasilleroInterfaz(Casillero casillero, boolean juegoHaComenzado){
        Posicion posicion = casillero.getPosicionCasillero();
        this.casillero = casillero;

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(TableroInterfaz.tamanioCasillero);
        rectangle.setHeight(TableroInterfaz.tamanioCasillero);
        rectangle.setStroke(Color.BLACK);
        relocate(posicion.posicionX * TableroInterfaz.tamanioCasillero,posicion.posicionY * TableroInterfaz.tamanioCasillero);
        if (posicion.posicionX < 10){
            casilleroAliado = true;
        }
        rectangle.setFill(casilleroAliado ? Color.valueOf("#feb") : Color.valueOf("#582"));
        getChildren().add(rectangle);

        setOnMouseClicked(e -> seleccionarUnidad(juegoHaComenzado));

    }

    private void seleccionarUnidad(boolean juegoHaComenzado) {
        if(juegoHaComenzado){
            FaseJuego.unidadSeleccionada = casillero.obtenerUnidad();
        }
    }

    public Posicion getPosicion(){
        return casillero.getPosicionCasillero();
    }

    public void setUnidad(UnidadInterfaz unidad){
        this.unidad = unidad;
        getChildren().add(unidad);
    }

    public UnidadInterfaz getUnidad(){
        return this.unidad;
    }
    public boolean casilleroAliado(){
        return casilleroAliado;
    }
}
