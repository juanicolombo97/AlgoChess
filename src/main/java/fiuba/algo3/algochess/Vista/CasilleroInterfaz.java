package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;


import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroInterfaz extends StackPane {

    private Casillero casillero;
    private UnidadInterfaz unidad;
    private boolean casilleroAliado;


    public CasilleroInterfaz(Casillero casillero){
        Posicion posicion = casillero.getPosicionCasillero();
        casilleroAliado = casillero.casilleroAliado;
        this.casillero = casillero;

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(TableroInterfaz.tamanioCasillero);
        rectangle.setHeight(TableroInterfaz.tamanioCasillero);
        rectangle.setStroke(Color.BLACK);
        relocate(posicion.getPosicionX() * TableroInterfaz.tamanioCasillero,posicion.getPosicionY() * TableroInterfaz.tamanioCasillero);
        rectangle.setFill(casilleroAliado ? Color.valueOf("#feb") : Color.valueOf("#582"));
        getChildren().add(rectangle);
    }

    public Posicion getPosicion(){
        return casillero.getPosicionCasillero();
    }

    public void setUnidad(UnidadInterfaz unidad){
        this.unidad = unidad;
        getChildren().add(unidad);
    }
    public boolean casilleroAliado(){
        return casilleroAliado;
    }
}
