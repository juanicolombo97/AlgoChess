package fiuba.algo3.algochess.Modelo.acciones;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Casillero;
import fiuba.algo3.algochess.Modelo.juego.Distancia;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;

import java.util.HashMap;
import java.util.Map;

public class AccionesFabrica {


    public void iniciarAccion(Unidad atacante, Unidad atacado, Map<Posicion, Casillero> tablero, boolean esUnidadAliada, Distancia distancia) {
        distancia.calcularDistanciaAccion(atacante,atacado,esUnidadAliada,tablero);
    }


}
