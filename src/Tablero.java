import java.util.*;

public class Tablero {
    private Hashtable casilleros;
    private Hashtable posicionDeUnidad;

    public Tablero(){
        this.casilleros = new Hashtable();
        this.posicionDeUnidad = new Hashtable();
        for(int i = 1; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Casillero casillero = this.asignarEquipo(i, j);
                String numi = Integer.toString(i);
                String numj = Integer.toString(j);
                String numCasillero = numi + " " + numj;
                this.casilleros.put(numCasillero, casillero);
            }
        }
    }

    private Casillero asignarEquipo (Integer i, Integer j){
        if (i <= 10 && j <= 10){
            return new CasilleroAzul();
        } else {
            return new CasilleroRojo();
        }
    }

    public void moverUnidad(Unidades unidad, String casillero){
        Casillero celda = (Casillero) this.casilleros.get(casillero);
        if (celda.esta_vacio()) {
            // si la unidad ya está en el tablero la posiciona en el nuevo casillero
            if (posicionDeUnidad.containsKey(unidad)) {
                Casillero posicion = (Casillero) posicionDeUnidad.get(unidad);
                posicion.mover_unidad_a(celda);
                posicionDeUnidad.replace(unidad, celda);
            }
            //else, la posiciona directamente en el casillero
            else {
                celda.recibir_unidad(unidad);
                posicionDeUnidad.put(unidad, celda);
            }
        }
    }

    public int cantUnidades(){
        return posicionDeUnidad.size();
    }

    public Casillero getPosicionDeUnidad(Unidades unidad){
        return((Casillero) posicionDeUnidad.get(unidad));
    }

    public Casillero getCasillero (String numCasillero){
        return (Casillero) casilleros.get(numCasillero);
    }
}
