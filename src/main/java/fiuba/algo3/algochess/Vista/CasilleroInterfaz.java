package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Posicion;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroInterfaz extends Rectangle {

    private Casillero casillero;

    public CasilleroInterfaz(Casillero casillero){
        Posicion posicion = casillero.getPosicionCasillero();
        boolean color = casillero.casilleroAliado;
        this.casillero = casillero;

        setWidth(TableroInterfaz.tamanioCasillero);
        setHeight(TableroInterfaz.tamanioCasillero);
        setStroke(Color.BLACK);
        relocate(posicion.getPosicionX() * TableroInterfaz.tamanioCasillero,posicion.getPosicionY() * TableroInterfaz.tamanioCasillero);
        setFill(color ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}
