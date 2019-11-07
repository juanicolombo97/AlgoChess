import Excepciones.CasilleroOcupadoExcenption;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

    @Test
    public void tableroVacioDeUnidadesAlCrearTablero() {
        Tablero tablero = new Tablero();
        Assert.assertEquals(0, tablero.cantUnidades());
    }

    @Test
    public void agregarUnidadHaceQueTableroNoEsteVacio() throws CasilleroOcupadoExcenption {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(3,3);
        tablero.moverUnidad(soldado, "1 2");
        Assert.assertEquals(1, tablero.cantUnidades());
    }

    @Test
    public void agregarMasDeUnaUnidadAlTablero() throws CasilleroOcupadoExcenption{
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(2,2);
        Curandero curandero = new Curandero(3,3);
        tablero.moverUnidad(soldado, "1 1");
        tablero.moverUnidad(curandero, "1 2");
        Assert.assertEquals(2, tablero.cantUnidades());
    }

    @Test
    public void agregarUnidadAUnCasilleroOcupadoNoAgregaUnidad() throws CasilleroOcupadoExcenption {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(4,4);
        Curandero curandero = new Curandero(5,5);
        tablero.moverUnidad(soldado, "1 2");
        tablero.moverUnidad(curandero, "1 2");
        Assert.assertEquals(1, tablero.cantUnidades());
    }

    @Test
    public void moverUnidadEfectivamenteMueveUnidad() throws CasilleroOcupadoExcenption {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(2,2);
        tablero.moverUnidad(soldado, "1 2");
        Casillero posicionSoldadoAnterior = tablero.getPosicionDeUnidad(soldado);
        tablero.moverUnidad(soldado, "2 2");
        Casillero posicionSoldadoActual = tablero.getPosicionDeUnidad(soldado);
        Assert.assertNotEquals(posicionSoldadoAnterior, posicionSoldadoActual);
    }

    @Test
    public void unaUnidadNoPuedeMoverseAUnCasilleroOcupado() throws CasilleroOcupadoExcenption {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(2,2);
        Curandero curandero = new Curandero(1,1);
        tablero.moverUnidad(soldado, "1 1");
        tablero.moverUnidad(curandero, "1 2");
        tablero.moverUnidad(soldado, "1 2");
        Casillero posicionSoldado = tablero.getPosicionDeUnidad(soldado);
        Casillero posicionCurandero = tablero.getPosicionDeUnidad(curandero);
        Assert.assertNotEquals(posicionSoldado, posicionCurandero);
    }

    @Test
    public void casoBordeAlCrearMoverUnidadFueraDelTablero() throws CasilleroOcupadoExcenption{
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(1,1);
        try {
            tablero.moverUnidad(soldado, "21 1");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void crearTableroAsignaEquiposALosCasilleros() {
        Tablero tablero = new Tablero();
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                String numi = Integer.toString(i);
                String numj = Integer.toString(j);
                String numCasillero = numi + " " + numj;
                Casillero casilleroActual = tablero.getCasillero(numCasillero);
                CasilleroAzul casilleroAzul = new CasilleroAzul();
                Assert.assertEquals(casilleroAzul.getClass(), casilleroActual.getClass());
            }
        }
        for (int i = 11; i < 20; i++) {
            for (int j = 11; j < 20; j++) {
                String numi = Integer.toString(i);
                String numj = Integer.toString(j);
                String numCasillero = numi + " " + numj;
                Casillero casilleroActual = tablero.getCasillero(numCasillero);
                CasilleroRojo casilleroRojo = new CasilleroRojo();
                Assert.assertEquals(casilleroRojo.getClass(), casilleroActual.getClass());
            }
        }
    }
}