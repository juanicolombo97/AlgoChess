package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;

import java.util.ArrayList;

//Clase donde se implementa la fiuba.algo3.algochess.unidades.Unidad fiuba.algo3.algochess.unidades.Catapulta

public class Catapulta implements Unidad {
    private static int costoUnidad = 5;
    private double vidaUnidad = 50;
    private static double danioDistancia = 20;
    private Posicion posicion = new Posicion();
    private Batallon batallon = new Batallon();
    private Emisario emisario;

    public Catapulta(int posicionX,int posicionY, Emisario emisario) {
        posicion.posicionNueva(posicionX,posicionY);
        this.emisario = emisario;
    }

    public double getVidaUnidad(){
        return vidaUnidad;
    }

    @Override
    public void atacarDistanciaCerca(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaMediana(Unidad atacado, double danioExtra) throws NoPuedeAtacarException {
        throw new NoPuedeAtacarException("La catapulta solo ataca a distancia");
    }

    @Override
    public void atacarDistanciaLejana(Unidad atacado, double danioExtra, Casillero[][] arrayCasillero) throws NoPuedeAtacarException, UnidadNulaException {
        ArrayList unidadesAAtacar = batallon.calcularBatallon(atacado,arrayCasillero);
        for (int x = 0 ; x < unidadesAAtacar.size() ; x++){
            ((Unidad) unidadesAAtacar.get(x)).recibirDanio(danioDistancia + (danioExtra * danioDistancia));
        }
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
        throw new CurarException("La catapulta no puede ser curada");
    }
    @Override
    public void moverUnidad(int posicionNuevaX, int posicionNuevaY) throws UnidadNulaException, MovimientoInvalidoException {
       throw new MovimientoInvalidoException("La catapulta no se puede mover");
    }
    @Override
    public void modificarPosicion(int posicionX, int posicionY){
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}