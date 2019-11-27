package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;

import java.util.HashMap;

public class JineteEspadachin implements EstadoJinete {
    private static double danio = 5;
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
        atacado.recibirDanio(danio );
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException {
        throw new NoPuedeAtacarException("El jinete espadachin no puede atacar a distancias medianas");
    }

}
