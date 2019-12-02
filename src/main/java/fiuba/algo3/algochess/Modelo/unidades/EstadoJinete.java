package fiuba.algo3.algochess.Modelo.unidades;

import fiuba.algo3.algochess.Modelo.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.Modelo.excepciones.UnidadNulaException;

public interface EstadoJinete {
    public EstadoJinete cambiarEstadoJinete(String estado);

    public void atacarDistanciaCerca(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException;

    public void atacarDistanciaMediana(Unidad atacado) throws NoPuedeAtacarException, UnidadNulaException;

    public void atacarDistanciaLejana(Unidad atacado) throws NoPuedeAtacarException;

    public boolean esArquero();
}

