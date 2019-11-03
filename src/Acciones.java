
import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Acciones {

    public void atacarCuerpo(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacante.atacarCuerpo(atacado);
    }

    public void atacarDistancia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacante.atacarDistancia(atacado);
    }

    public void curarAUnidad(Curandero curandero, Unidades unidadACurar) throws CurarCatapultaException {
        curandero.curar(unidadACurar);
    }
}
