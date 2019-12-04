package fiuba.algo3.algochess.Modelo.excepciones;
// Se lanza si el jugador crea una unidad y no le alcanzan los puntos.

public class NoAlcanzanLosPuntosException extends RuntimeException{
    public NoAlcanzanLosPuntosException(String msg) {
        super((msg));
    }
}
