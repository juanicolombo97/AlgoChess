import Excepciones.CurarException;
import Excepciones.NoPuedeAtacarException;
import Excepciones.UnidadNulaException;

public class AccionMedia {

    public AccionMedia(Unidad atacante, Unidad atacado, double danioExtra) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        atacante.atacarDistanciaMediana(atacado,danioExtra);
    }
}
