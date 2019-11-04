import java.util.*;

public class Tablero {
    private Dictionary casilleros = new Hashtable();
    private Dictionary posicionDeUnidad = new Hashtable()

    public void moverUnidad(Unidades unidad, String casillero){
        Casillero celda = this.casilleros.get(casillero);
        // si la unidad ya está en el tablero la posiciona en el nuevo casillero
        if(posicionDeUnidad.containsKey(unidad)){
            Casillero posicion = posicionDeUnidad.get(unidad);
            posicion.mover_unidad_a(celda);
        }
        //else, la posiciona directamente en el casillero
        else {
            celda.recibir_unidad(unidad);
            posicionDeUnidad.put(unidad, celda);
        }
    }
}
