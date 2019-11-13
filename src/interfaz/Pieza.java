package interfaz;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Pieza extends StackPane {

    private TipoPieza tipo;
    private double oldX,oldY;
    private double mouseX,mouseY;

    public TipoPieza getTipo() {
        return tipo;
    }
    public Pieza(TipoPieza tipoPieza, int x, int y){
        this.tipo = tipoPieza;

        mover(x , y );
        Ellipse bg = new Ellipse(AlgoChess.tileSize * 0.3125, AlgoChess.tileSize * 0.26);
        bg.setFill(tipo == TipoPieza.RED ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(AlgoChess.tileSize * 0.03);

        bg.setTranslateX((AlgoChess.tileSize - AlgoChess.tileSize * 0.3125 * 2) / 2);
        bg.setTranslateY((AlgoChess.tileSize - AlgoChess.tileSize * 0.26 * 2) / 2);

        Ellipse ellipse = new Ellipse();
        bg.setFill(tipo == TipoPieza.WHITE ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(AlgoChess.tileSize * 0.03);

        bg.setTranslateX((AlgoChess.tileSize - AlgoChess.tileSize * 0.3125 * 2) / 2);
        bg.setTranslateY((AlgoChess.tileSize - AlgoChess.tileSize * 0.26 * 2) / 2 + AlgoChess.tileSize * 0.07);

        getChildren().addAll(bg, ellipse);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void mover(int x, int y) {
        oldX =  x * AlgoChess.tileSize;
        oldY = y * AlgoChess.tileSize;
        relocate(oldX,oldY);


    }

    public double getOldX(){
        return oldX;
    }

    public double getOldY(){
        return oldY;
    }

    public void abortMove(){
        relocate(oldX,oldY);
    }
}
