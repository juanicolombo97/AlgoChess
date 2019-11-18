import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionLejana {

    public AccionLejana(Unidad atacante, Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacante.atacarDistanciaLejana(atacado,danioExtra);
    }
}
