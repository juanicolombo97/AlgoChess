package interfaz;

public class ResultadoMovimiento {

    private TipoMovimiento tipoMovimiento;

    public TipoMovimiento getTipoMovimiento(){
        return tipoMovimiento;
    }

    private Pieza pieza;

    public Pieza getPieza(){
        return pieza;
    }

    public ResultadoMovimiento(TipoMovimiento tipoMovimiento){
        this(tipoMovimiento ,null);
    }

    public ResultadoMovimiento(TipoMovimiento tipo,Pieza pieza){
        this.tipoMovimiento = tipo;
        this.pieza = pieza;
    }
}
