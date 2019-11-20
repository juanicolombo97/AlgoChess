import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionCercana implements Accion{

    @Override
    public void atacar(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException{
        atacante.atacarDistanciaCerca(atacado);
    }
}
