import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

    @Test
    public void tableroVacioDeUnidadesAlCrearTablero(){
        Tablero tablero = new Tablero();
        Assert.assertEquals(0, tablero.cantUnidades());
    }

    @Test
    public void agregarUnidadHaceQueTableroNoEsteVacio() {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        tablero.moverUnidad(soldado, "1 2");
        Assert.assertEquals(1, tablero.cantUnidades());
    }

    @Test
    public void agregarMasDeUnaUnidadAlTablero(){
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        tablero.moverUnidad(soldado, "1 1");
        tablero.moverUnidad(curandero, "1 2");
        Assert.assertEquals(2, tablero.cantUnidades());
    }

    @Test
    public void agregarUnidadAUnCasilleroOcupadoNoAgregaUnidad(){
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        tablero.moverUnidad(soldado, "1 2");
        tablero.moverUnidad(curandero, "1 2");
        Assert.assertEquals(1, tablero.cantUnidades());
    }

    @Test
    public void moverUnidadEfectivamenteMueveUnidad(){
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        tablero.moverUnidad(soldado, "1 2");
        Casillero posicionSoldadoAnterior = tablero.getPosicionDeUnidad(soldado);
        tablero.moverUnidad(soldado, "2 2");
        Casillero posicionSoldadoActual = tablero.getPosicionDeUnidad(soldado);
        Assert.assertNotEquals(posicionSoldadoAnterior, posicionSoldadoActual);
    }

    @Test
    public void unaUnidadNoPuedeMoverseAUnCasilleroOcupado(){
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        tablero.moverUnidad(soldado, "1 1");
        tablero.moverUnidad(curandero, "1 2");
        tablero.moverUnidad(soldado, "1 2");
        Casillero posicionSoldado = tablero.getPosicionDeUnidad(soldado);
        Casillero posicionCurandero = tablero.getPosicionDeUnidad(curandero);
        Assert.assertNotEquals(posicionSoldado, posicionCurandero);
    }

}