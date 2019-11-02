public class Soldado implements Unidades{
    private static int costoUnidad = 1;
    private int vidaUnidad = 100;
    private static int danioCuerpo = 10;
    private static int danioDistancia = 0;

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
    public void modificarVida(int cambioVida){
        vidaUnidad += cambioVida;
    }

}
