import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class AccionLejana {

    public AccionLejana(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaLejana(atacado);
    }
}
