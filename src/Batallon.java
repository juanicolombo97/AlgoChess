import java.util.ArrayList;

public class Batallon {

    private int contador = 0;
    private ArrayList listaUnidades = new ArrayList();
    private UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
    private ArrayList unidadesAMover = new ArrayList();


    public ArrayList moverBatallon(Casillero[][] arrayCasillero, int posicionInicialX, int posicionInicialY) {
        listaUnidades.add(arrayCasillero[posicionInicialX][posicionInicialY].getUnidad());
        do {
            System.out.println(listaUnidades);
            Unidad unidad = (Unidad) listaUnidades.remove(0);
            contador++;
            unidadesAMover.add(unidad);
            unidadesCercanas.unidadesCercanas(unidad,listaUnidades,arrayCasillero);
        }while (contador != 3 || listaUnidades.size() != 0);

        return unidadesAMover;
    }


}
