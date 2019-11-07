import Excepciones.CasilleroOcupadoExcenption;

public class Casillero {
    private Unidades unidad_actual = null;

    public boolean esta_vacio(){
        return (this.unidad_actual == null);
    }
    // Mueve unidad a otro casillero, elimina la guardada en el atributo unidad_actual
    public void mover_unidad_a(Casillero destino) throws CasilleroOcupadoExcenption {
        destino.recibir_unidad(this.unidad_actual);
        this.unidad_actual = null;
    }
    // Recibe unidad de otro casillero
    public void recibir_unidad(Unidades unidad) throws CasilleroOcupadoExcenption {
        if (!this.esta_vacio()) {
            throw new CasilleroOcupadoExcenption("El casillero esta ocupado");
        }
        unidad_actual = unidad;
    }

    public Unidades getUnidad(){
        return unidad_actual;
    }
}