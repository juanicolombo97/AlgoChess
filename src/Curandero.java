public class Curandero implements Unidades{
    private static int costoUnidad = 2;
    private int vidaUnidad = 75;
    private static int curacion = 15;


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
        return 0;
    }

    @Override
    public int getDanioDist() {
        return 0;
    }

    @Override
    public void modificarVida(int cambioVida) {
        vidaUnidad += cambioVida;
    }

    public int curar(){
        return curacion;
    }
}
