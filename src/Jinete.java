public class Jinete implements Unidades {
    private static int costoUnidad = 3;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 5;
    private static int danioDistancia = 15;


    @Override
    public int getCosto() {
        return costoUnidad;
    }

    @Override
    public int getVida() {
        return vidaUnidad;
    }

    @Override
    public int getDanio() {
        return danioCuerpo;
    }

    @Override
    public int getDanioDist() {
        return danioDistancia;
    }

    @Override
    public void modificarVida(int cambioVida) {
        vidaUnidad += cambioVida;
    }
}
