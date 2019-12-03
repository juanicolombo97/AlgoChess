package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class AjustaDanio {

    private Jugador jugador;

    public AjustaDanio(Jugador jugador){
        this.jugador = jugador;
    }

    public double ajustarDanio(double danioRecibido, Unidad atacado){
        if (jugador.casilleroAliadoPorPosicion(atacado.getPosicion())){
            return danioRecibido + (danioRecibido * 0.05);
        }
        return danioRecibido;
    }
}
