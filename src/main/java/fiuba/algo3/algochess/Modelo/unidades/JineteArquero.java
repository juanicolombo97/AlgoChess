package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

import java.util.HashMap;

public class JineteArquero implements EstadoJinete{
    private double danio = 15;
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
    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias cortas");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danio);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias lejanas");
    }

    @Override
    public boolean esArquero(){return true;}
}
