package Excepciones;
// Se lanza si el jugador crea una unidad y no le alcanzan los puntos.

public class NoAlcanzanLosPuntosException extends Exception{
    public NoAlcanzanLosPuntosException(String msg) {
        super((msg));
    }
}
