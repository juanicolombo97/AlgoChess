public class Catapulta implements Unidades {
    private static int costoUnidad = 5;
    private int vidaUnidad = 50;
    private static int danioCuerpo = 0;
    private static int danioDistancia = 20;

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
    @Override
    public String toString() {
        return "Catapulta";
    }
}
