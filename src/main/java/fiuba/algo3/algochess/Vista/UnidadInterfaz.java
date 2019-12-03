package fiuba.algo3.algochess.Vista;

import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UnidadInterfaz extends Circle {

    private Unidad unidad;
    private Posicion posicion;

    public UnidadInterfaz(Unidad unidad){
        this.unidad = unidad;
        posicion = unidad.getPosicion();

        Circle unidadCirculo = new Circle(TableroInterfaz.tamanioCasillero * 0.3125);
        unidadCirculo.setFill(Color.BLACK);
        setFill(Color.BLACK);
        relocate(posicion.getPosicionX() * TableroInterfaz.tamanioCasillero,posicion.getPosicionY() * TableroInterfaz.tamanioCasillero);

    }

}
