import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacante.atacarDistanciaLejana(atacado);
    }
}
