import java.util.*;

public class Tablero {
    private Dictionary casilleros;
    private Dictionary posicionDeUnidad;

    public Tablero(){
    /*    this.casilleros = new Hashtable();
        this.posicionDeUnidad = new Hashtable();
        for(int i = 1; i < 21; i++){
            for(int j = 1; j < 21; j++){
                Casillero casillero = new Casillero();
                String numi = Integer.toString(i);
                String numj = Integer.toString(j);
                String numCasillero = numi + " " + numj;
                this.casilleros.put(numCasillero, casillero);
            }
        }*/
    }

    public void moverUnidad(Unidades unidad, String casillero){
    /*    Casillero celda = this.casilleros.get(casillero);
        // si la unidad ya está en el tablero la posiciona en el nuevo casillero
        if(posicionDeUnidad.containsKey(unidad)){
            Casillero posicion = posicionDeUnidad.get(unidad);
            posicion.mover_unidad_a(celda);
        }
        //else, la posiciona directamente en el casillero
        else {
            celda.recibir_unidad(unidad);
            posicionDeUnidad.put(unidad, celda);
        }*/
    }
}
