import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public interface Accion{
    public void atacar(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException;
}
