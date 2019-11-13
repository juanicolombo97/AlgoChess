package interfaz;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AlgoChess{

    public static final int tileSize = 100;
    public static final int width = 8;
    public static final int height = 8;

    private Group casilleroGrupo = new Group();
    private Group piezasGrupo = new Group();
    private Casillero[][] board = new Casillero[width][height];

    public Pane crearContenido(){
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize);
        root.getChildren().addAll(casilleroGrupo,piezasGrupo);
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                Casillero casillero = new Casillero((x + y) % 2 ==0, x,y);
                board[x][y] = casillero;
                casilleroGrupo.getChildren().add(casillero);
                Pieza pieza = null;

                if (y <= 2 && (x + y) % 2 != 0 ){
                    pieza = crearPieza(TipoPieza.RED,x,y);
                }
                if (y >= 5 && (x + y) % 2 != 0 ){
                    pieza = crearPieza(TipoPieza.WHITE,x,y);
                }
                if (pieza != null) {
                    casillero.setPieza(pieza);
                    piezasGrupo.getChildren().add(pieza);
                }
            }
        }
        return root;
    }

    public void displayAlgoChess(JugadoresRegistro jugadoresRegistro){
        Stage ventanaAlgoChess = new Stage();
        Scene scene = new Scene(crearContenido());


        ventanaAlgoChess.setTitle("AlgoChess");
        ventanaAlgoChess.setScene(scene);
        ventanaAlgoChess.setFullScreen(true);
        ventanaAlgoChess.show();

    }

    public Pieza crearPieza(TipoPieza tipo,int x ,int y){
        Pieza pieza = new Pieza(tipo,x,y);

        pieza.setOnMouseReleased(e -> {
            int newX = toBoard(pieza.getLayoutX());
            int newY = toBoard(pieza.getLayoutY());

            ResultadoMovimiento resultado = tryMove(pieza,newX,newY);

            int x0 = toBoard(pieza.getOldX());
            int y0 = toBoard(pieza.getOldY());

            switch (resultado.getTipoMovimiento()) {
                case NONE:
                    pieza.abortMove();
                    break;
                case NORMAL:
                    pieza.mover(newX,newY);
                    board[x0][y0].setPieza(null);
                    board[newX][newY].setPieza(pieza);
                    break;
                case KILL:
                    pieza.mover(newX,newY);
                    board[x0][y0].setPieza(null);
                    board[newX][newY].setPieza(pieza);

                    Pieza otraPieza = resultado.getPieza();
                    board[toBoard(otraPieza.getOldX())][toBoard(otraPieza.getOldY())].setPieza(null);
                    piezasGrupo.getChildren().remove(otraPieza);
                    break;
            }
        });
        return pieza;
    }

    private ResultadoMovimiento tryMove(Pieza pieza, int newX, int newY) {
        if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0){
            return  new ResultadoMovimiento(TipoMovimiento.NONE);
        }
        int x0 = toBoard(pieza.getOldX());
        int y0 = toBoard(pieza.getOldY());

        if (Math.abs(newX - x0) == 1 && newY - y0 == pieza.getTipo().direccionMovimiento){
            return new ResultadoMovimiento(TipoMovimiento.NORMAL);
        }else if (Math.abs(newX - x0) == 2 && newY - y0 == pieza.getTipo().direccionMovimiento * 2){
            int x1 = x0 + (newX - x0) / 2;
            int y1 = y0 + (newY - y0) / 2;
            if (board[x1][y1].hasPiece() && board[x1][y1].getPieza().getTipo() != pieza.getTipo()){
                return new ResultadoMovimiento(TipoMovimiento.KILL, board[x1][y1].getPieza());
            }
        }
        return new ResultadoMovimiento(TipoMovimiento.NONE);
    }

    public int toBoard(double pixel){
        return (int)(pixel + AlgoChess.tileSize / 2) / AlgoChess.tileSize;
    }


}
