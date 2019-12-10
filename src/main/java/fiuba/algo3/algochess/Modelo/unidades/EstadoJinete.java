package fiuba.algo3.algochess.Modelo.unidades;

public interface EstadoJinete {

    public void atacarDistanciaCerca(Unidad atacado);

    public void atacarDistanciaMediana(Unidad atacado);

    public void atacarDistanciaLejana(Unidad atacado);

    public boolean esArquero();

    public JineteArquero setEstadoJineteArquero();

    public JineteEspadachin setEstadoJineteEspadachin();
}

