package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;

public class JineteArquero implements EstadoJinete{
    private double danio = 15;

    @Override
    public void atacarDistanciaCerca(Unidad atacado) {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias cortas");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado) {
        atacado.recibirDanio(danio);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado) {
        throw new NoPuedeAtacarException("El jinete arquero no puede atacar a distancias lejanas");
    }

    @Override
    public boolean esArquero(){return true;}

    @Override
    public JineteArquero setEstadoJineteArquero() {
        return new JineteArquero();
    }

    @Override
    public JineteEspadachin setEstadoJineteEspadachin() {
        return new JineteEspadachin();
    }
}
