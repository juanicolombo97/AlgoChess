import Excepciones.CurarCatapultaException;

public class Acciones {

    public void atacarCuerpo(Unidades atacante, Unidades atacado){
        atacado.modificarVida(-(atacante.getDanio()));
    }

    public void atacarDistancia(Unidades atacante, Unidades atacado){
        atacado.modificarVida(-(atacante.getDanioDist()));
    }

    public void curarAUnidad(Curandero curandero, Unidades unidadCurar) throws CurarCatapultaException {
        if(unidadCurar.toString() == "Catapulta") {
            throw new CurarCatapultaException();
        }
        unidadCurar.modificarVida(curandero.curar());
    }
}
