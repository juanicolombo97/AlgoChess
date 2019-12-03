package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

import java.util.HashMap;

public class JineteEspadachin implements EstadoJinete{
    private double danio = 5;
    private static HashMap estadosJineteDisponibles = new HashMap();

    @Override
    public EstadoJinete cambiarEstadoJinete(String estado) {
        llenarEstadosJinetePosibles();
        return (EstadoJinete) estadosJineteDisponibles.get(estado);
    }

    private void llenarEstadosJinetePosibles() {
        JineteEspadachin jineteEspadachin = new JineteEspadachin();
        JineteArquero jineteArquero = new JineteArquero();
        estadosJineteDisponibles.put("espadachin",jineteEspadachin);
        estadosJineteDisponibles.put("arquero",jineteArquero);
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, boolean conDanioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danio, conDanioExtra);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, boolean conDanioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        throw new NoPuedeAtacarException("El jinete espadachin no puede atacar a distancias medianas");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, boolean conDanioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete espadachin no puede atacar a distancias lejanas");
    }

    @Override
    public boolean esArquero(){return false;}
}
