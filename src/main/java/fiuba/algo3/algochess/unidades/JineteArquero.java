package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;

import java.util.HashMap;

public class JineteArquero implements EstadoJinete {
    private static double danio = 15;
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
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias cortas");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        atacado.recibirDanio(danio + (danioExtra * danio));
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra, Casillero[][] arrayCasillero) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias lejanas");
    }
}