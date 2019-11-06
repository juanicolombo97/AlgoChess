import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;

public class AccionMedia {

    public AccionMedia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException, CurarException {
        atacante.atacarDistanciaMediana(atacado);
    }
}
