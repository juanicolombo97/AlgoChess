package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.unidades.Unidad;

public class AjustaDanioActivo implements AjustaDanio{

    private Jugador jugador;

    public AjustaDanioActivo(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public double ajustarDanio(double danioRecibido, Unidad atacado){
        if (jugador.casilleroAliadoPorPosicion(atacado.getPosicion())){
            return danioRecibido + (danioRecibido * 0.05);
        }
        return danioRecibido;
    }
}
