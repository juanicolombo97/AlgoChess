import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class AccionCercana {

    public AccionCercana(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaCerca(atacado);
    }
}
