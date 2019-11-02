import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;

public class Acciones {

    public void atacarCuerpo(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacado.atacado(atacante.getDanio());
    }

    public void atacarDistancia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacado.atacado(atacante.getDanioDist());
    }

    public void curarAUnidad(Curandero curandero, Unidades unidadCurar) throws CurarCatapultaException {
        unidadCurar.curar(curandero.getCuracion());
    }
}
