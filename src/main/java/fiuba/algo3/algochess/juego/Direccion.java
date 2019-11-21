package fiuba.algo3.algochess.juego;

import java.util.ArrayList;
import java.util.HashMap;

public class Direccion {

    private int x;
    private int y;
    private HashMap puntosCardinales = new HashMap();



    public Direccion(String coordenada){
        establecerCoordenadas();
        String puntoCardinal = coordenada.toLowerCase();
        int[] puntos = (int[]) this.puntosCardinales.get(puntoCardinal);
        this.x = puntos[0];
        this.y = puntos[1];
    }

    private void establecerCoordenadas() {
        int[] nula = {0, 0};
        int[] norte = {0, 1};
        int[] noreste = {1, 1};
        int[] este = {1, 0};
        int[] sureste = {1, -1};
        int[] sur = {0, -1};
        int[] suroeste = {-1, -1};
        int[] oeste = {-1, 0};
        int[] noroeste = {-1, 1};

        this.puntosCardinales.put("nula", nula);
        this.puntosCardinales.put("norte", norte);
        this.puntosCardinales.put("noreste", noreste);
        this.puntosCardinales.put("este", este);
        this.puntosCardinales.put("sureste", sureste);
        this.puntosCardinales.put("sur", sur);
        this.puntosCardinales.put("suroeste", suroeste);
        this.puntosCardinales.put("oeste", oeste);
        this.puntosCardinales.put("noroeste", noroeste);
    }

    public ArrayList direccionesMovimiento(){
        ArrayList listaDirecciones = new ArrayList();

        Direccion norte = new Direccion("norte");
        Direccion sur = new Direccion("sur");
        Direccion este = new Direccion("este");
        Direccion oeste = new Direccion("oeste");
        Direccion noreste = new Direccion("noreste");
        Direccion noroeste = new Direccion("noroeste");
        Direccion sureste = new Direccion("sureste");
        Direccion suroeste = new Direccion("suroeste");

        listaDirecciones.add(norte);
        listaDirecciones.add(sur);
        listaDirecciones.add(este);
        listaDirecciones.add(oeste);
        listaDirecciones.add(noreste);
        listaDirecciones.add(noroeste);
        listaDirecciones.add(sureste);
        listaDirecciones.add(suroeste);

        return listaDirecciones;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}
