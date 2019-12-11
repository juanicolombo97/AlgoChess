package fiuba.algo3.algochess.Controlador;


import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class Atacar {
    public Atacar(Juego juego, Unidad unidadAtacante, Unidad unidadAtacada) {
        Posicion posicionAtacante = unidadAtacante.getPosicion();
        Posicion posicionAtacada = unidadAtacada.getPosicion();
        juego.atacar(posicionAtacante,posicionAtacada);
    }
}
