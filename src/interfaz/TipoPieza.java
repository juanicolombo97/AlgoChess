package interfaz;

public enum  TipoPieza {
    RED(1),WHITE(-1);
    final int direccionMovimiento;

    TipoPieza(int direccionMovimiento){
        this.direccionMovimiento = direccionMovimiento;
    }
}
