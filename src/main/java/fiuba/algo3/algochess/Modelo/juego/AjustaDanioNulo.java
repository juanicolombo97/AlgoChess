package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class AjustaDanioNulo implements AjustaDanio{

    private Jugador jugador;

    @Override
    public double ajustarDanio(double danioRecibido, Unidad atacado){
        return danioRecibido;
    }
}
