package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

public class Jinete implements Unidad {
    private static int costoUnidad = 3;
    private double vidaUnidad = 100;
    private EstadoJinete estadoJinete = new JineteArquero(); //default
    private Posicion posicion = new Posicion();
    private Emisario emisario;

    public Jinete(int posicionX,int posicionY, Emisario emisario){
        posicion.posicionNueva(posicionX,posicionY);
        this.emisario = emisario;
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    public void setEstadoJinete(String estado){
        estadoJinete = (EstadoJinete) estadoJinete.cambiarEstadoJinete(estado);
    }

    @Override
    public void modificarPosicion(int posicionX, int posicionY) {
        posicion.posicionNueva(posicionX,posicionY);
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        estadoJinete.atacarDistanciaCerca(atacado,danioExtra);
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException, UnidadNulaException {
        estadoJinete.atacarDistanciaMediana(atacado,danioExtra);
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra, Casillero[][] arrayCasillero) throws NoPuedeAtacarException {
        estadoJinete.atacarDistanciaLejana(atacado,danioExtra,arrayCasillero);
    }

    @Override
    public void recibirDanio(double danioRecibido) {
        vidaUnidad -= danioRecibido;
    }

    @Override
    public int cuantoCuesta() {
        return costoUnidad;
    }

    @Override
    public void curarse(int vidaACurar) throws CurarException {
        vidaUnidad += vidaACurar;
    }

    @Override
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
        posicion.posicionValida(posicionNuevaX,posicionNuevaY);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public void recibirNotificacion() {
        if (emisario.unidadesAliadasCercanas(this).size() == 0 && emisario.unidadesEnemigasCercanas(this).size() > 0){
            setEstadoJinete("espadachin");
        } else if (emisario.unidadesAliadasCercanas(this).size() > 0 || emisario.unidadesEnemigasCercanas(this).size() == 0)
            setEstadoJinete("arquero");

    }

    public EstadoJinete getEstado(){
        return estadoJinete;
    }
}
