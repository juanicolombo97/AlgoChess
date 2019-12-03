package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;


import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroInterfaz extends Rectangle {

    private Casillero casillero;
    private Unidad unidad;


    public CasilleroInterfaz(Casillero casillero){
        Posicion posicion = casillero.getPosicionCasillero();
        boolean color = casillero.esCasilleroAliado();
        this.casillero = casillero;

        setWidth(TableroInterfaz.tamanioCasillero);
        setHeight(TableroInterfaz.tamanioCasillero);
        setStroke(Color.BLACK);
        relocate(posicion.getPosicionX() * TableroInterfaz.tamanioCasillero,posicion.getPosicionY() * TableroInterfaz.tamanioCasillero);
        setFill(color ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }

    public Posicion getPosicion(){
        return casillero.getPosicionCasillero();
    }

    public void setUnidad(Unidad unidad){
        this.unidad = unidad;
    }
}
