package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;

public class Casillero {
    private Unidad unidad_actual = new UnidadNull();

    public boolean esta_vacio(){
        UnidadNull unidadNull = new UnidadNull();
        return (this.unidad_actual.getClass() == unidadNull.getClass());
    }

    // Mueve unidad a otro casillero, elimina la guardada en el atributo unidad_actual
    public void mover_unidad_a(Casillero destino, int posicionX,int posicionY) throws CasilleroOcupadoException {
        unidad_actual.nuevaPosicion(posicionX,posicionY);
        destino.recibir_unidad(this.unidad_actual);
        this.unidad_actual = new UnidadNull();
    }
    // Recibe unidad de otro casillero
    public void recibir_unidad(Unidad unidad) throws CasilleroOcupadoException {
        if (!this.esta_vacio()) {
            throw new CasilleroOcupadoException("El casillero esta ocupado");
        }
        unidad_actual = unidad;
    }

    public Unidad getUnidad(){
        return unidad_actual;
    }
}