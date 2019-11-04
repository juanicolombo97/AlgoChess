import Excepciones.NoAlcanzanLosPuntosException;

public class Main {
    // Clase que empieza el juego.
    public static void main(String[] args) throws NoAlcanzanLosPuntosException, excepciones.UnidadInvalidaException {
        IniciarJuego juego = new IniciarJuego();
        juego.iniciarJuego();

    }
}

