package fiuba.algo3.algochess.Modelo.juego;

import java.util.ArrayList;
import java.util.List;

public class Direccion {

    private int x;
    private int y;

    private static Direccion norte;
    private static Direccion sur;
    private static Direccion este;
    private static Direccion oeste;
    private static Direccion noroeste;
    private static Direccion suroeste;
    private static Direccion sureste;
    private static Direccion noreste;

    static {
        norte = new Direccion(0, 1);
        sur = new Direccion(0, -1);
        este = new Direccion(1, 0);
        oeste = new Direccion(-1, 0);
        noreste = new Direccion(1,1);
        noroeste = new Direccion(-1,1);
        sureste = new Direccion(1,-1);
        suroeste = new Direccion(-1,-1);


    }
    public Direccion(int x, int y){
        this.x = x;
        this.y = y;

    }

    public List<Direccion> direccionesMovimiento(){
        List<Direccion> listaDirecciones = new ArrayList<>();

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


    public Posicion posicionNueva(int posicionX,int posicionY){
        return new Posicion(posicionX + this.x,posicionY + this.y);
    }

    public Posicion calcularPosicionCercana(int posicionX, int posicionY, int counter) {
        int posicionNuevaX = posicionX + counter * x;
        int posicionNuevaY = posicionY + counter * y;
        return new Posicion(posicionNuevaX,posicionNuevaY);
    }
}
