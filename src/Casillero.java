public class Casillero {
    private Unidades unidad_actual = null;
    public boolean esta_vacio(){
        return (this.unidad_actual == null);
    }
    // Mueve unidad a otro casillero, elimina la guardada en el atributo unidad_actual
    public void mover_unidad_a(Unidades unidad, Casillero destino){
        destino.recibir_unidad(unidad);
        this.unidad_actual = null;
    }
    // Recibe unidad de otro casillero
    public void recibir_unidad(Unidades unidad){
        if (this.esta_vacio()) {
            this.unidad_actual = unidad;
        }
    }
}