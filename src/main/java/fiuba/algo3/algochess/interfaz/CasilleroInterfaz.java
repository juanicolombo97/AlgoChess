package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroInterfaz extends Rectangle {

    private Casillero casillero;

    public CasilleroInterfaz(Casillero casillero){
        Posicion posicion = casillero.getPosicionCasillero();
        boolean color = casillero.casilleroAliado;
        this.casillero = casillero;

        setWidth(FaseInicial.tamanioCasillero);
        setHeight(FaseInicial.tamanioCasillero);
        relocate(posicion.getPosicionX() * FaseInicial.tamanioCasillero,posicion.getPosicionY() * FaseInicial.tamanioCasillero);
        setFill(color ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}
