
import Excepciones.CurarCatapultaException;
import Excepciones.NoPuedeAtacarException;


// Clase que sirve para realizar las acciones sobre las Unidades, como por ejemplo atacar a otra.

public class Acciones {

    // Funcion que recibe un atacante y un atacado. Le pasa a atacante la unidad a atacar.
    // Tira error si la unidad no puede atacar.

    public void atacarCuerpo(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacante.atacar(atacado);
    }

    // Funcion igual a la de arriba, solo que est ataca a distancia. Tira error si la Unidad no puede atacar.

    public void atacarDistancia(Unidades atacante, Unidades atacado) throws NoPuedeAtacarException {
        atacante.atacarDistancia(atacado);
    }

    // Funcion que recibe un curandero y una unidad a curar. Le pasa al curandero la unidad a curar y este lo cura.
    // Tira error si se quiere curar una catapulta.

    public void curarAUnidad(Curandero curandero, Unidades unidadACurar) throws CurarCatapultaException {
        curandero.curar(unidadACurar);
    }
}
