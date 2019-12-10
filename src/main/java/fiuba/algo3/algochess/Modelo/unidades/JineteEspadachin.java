package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;

public class JineteEspadachin implements EstadoJinete{
    private double danio = 5;

    @Override
    public void atacarDistanciaCerca(Unidad atacado) {
        atacado.recibirDanio(danio);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) {
        throw new NoPuedeAtacarException("El jinete espadachin no puede atacar a distancias medianas");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) {
        throw new NoPuedeAtacarException("El jinete espadachin no puede atacar a distancias lejanas");
    }

    @Override
    public JineteArquero setEstadoJineteArquero() {
        return new JineteArquero();
    }

    @Override
    public JineteEspadachin setEstadoJineteEspadachin() {
        return new JineteEspadachin();
    }
}
