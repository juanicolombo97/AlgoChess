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
    private boolean casilleroAliado = false;
    private Posicion posicion;


    public CasilleroInterfaz(Casillero casillero, int tamanioCasillero){
        this.posicion = casillero.getPosicionCasillero();
        this.casillero = casillero;

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(tamanioCasillero);
        rectangle.setHeight(tamanioCasillero);
        rectangle.setStroke(Color.BLACK);
        relocate(posicion.posicionX * tamanioCasillero,posicion.posicionY * tamanioCasillero);
        if (posicion.posicionX < 10){
            casilleroAliado = true;
        }
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

    public UnidadInterfaz getUnidad(){
        return unidad;
    }

    public void eliminarUnidad(){
        unidad = null;
    }

}
