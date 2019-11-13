package interfaz;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {

    public Pieza pieza;

    public boolean hasPiece() {
        return pieza != null;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }

    public Casillero(boolean color, int x, int y){
        setWidth(AlgoChess.tileSize);
        setHeight(AlgoChess.tileSize);

        relocate(x * AlgoChess.tileSize, y * AlgoChess.tileSize);
        setFill(color ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}
