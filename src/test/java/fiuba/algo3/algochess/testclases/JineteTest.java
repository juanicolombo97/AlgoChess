package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.unidades.Jinete;
import fiuba.algo3.algochess.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//Pruebas realizadas a la clase fiuba.algo3.algochess.unidades.Soldado.

class JineteTest {

    private Casillero[][] arrayCasillero;

    @Test
    //Cuando el jinete tiene enemigos cerca se vuelve espadachin y ataca de cerca
    public void JineteEspadachinPuedeAtacarADistanciaCortaYOcasionaElDañoCorrespondiente() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("espadachin");
        Soldado soldadoEnemigo = new Soldado(1,2);
        jinete.atacarDistanciaCerca(soldadoEnemigo, 0);
        Assertions.assertEquals(95,soldadoEnemigo.getVidaUnidad());
    }

    @Test
    //Cuando el jinete tiene enemigos cerca se vuelve espadachin y no puede atacar a distancia media
    public void JineteEspadachinNoPuedeAtacarADistanciaMedia() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("espadachin");
        Soldado soldadoEnemigo = new Soldado(4, 4);
        try {
            jinete.atacarDistanciaMediana(soldadoEnemigo, 0);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias medianas",e.getMessage());
        }
    }

    @Test
    //Jinete Espadachin no puede atacar a distancia Lejana
    public void JineteEspadachinNoPuedeAtacarADistanciaLejana() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("espadachin");
        Soldado soldadoEnemigo = new Soldado(19, 19);
        try {
            jinete.atacarDistanciaLejana(soldadoEnemigo, 0, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete espadachin no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
    //Cuando el jinete tiene aliados cerca, y no enemigos, es Jinete Arquero, y no puede atacar a distancia corta
    public void JineteArqueroNoPuedeAtacarADistanciaCorta() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("arquero");
        Soldado soldadoEnemigo = new Soldado(2, 1);
        try{
            jinete.atacarDistanciaCerca(soldadoEnemigo,0);
        }catch (NoPuedeAtacarException e) {
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias cortas", e.getMessage());
        }
    }

    @Test
    //Cuando el jinete tiene aliados cerca, y no enemigos, es Jinete Arquero, y puede atacar a distancia media
    public void JineteArqueroPuedeAtacarADistanciaMediaYOcasionaElDañoCorrespondiente() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("arquero");
        Soldado soldadoEnemigo = new Soldado(4, 4);
        jinete.atacarDistanciaMediana(soldadoEnemigo,0);
        Assertions.assertEquals(85,soldadoEnemigo.getVidaUnidad());
    }

    @Test
    //Jinete Arquero no puede atacar a distancia Lejana
    public void JineteArqueroNoPuedeAtacarADIstanciaLejana() throws NoPuedeAtacarException, UnidadNulaException{
        Jinete jinete = new Jinete(1,1);
        jinete.setEstadoJinete("arquero");
        Soldado soldadoEnemigo = new Soldado(19, 19);
        try {
            jinete.atacarDistanciaLejana(soldadoEnemigo, 0, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete arquero no puede atacar a distancias lejanas",e.getMessage());
        }
    }

    @Test
        //El jinete se cura correctamente
    public void jineteSeCuraCorrectamente() throws CurarException {
        Jinete jinete = new Jinete(1,1);
        jinete.curarse(30);
        Assertions.assertEquals(130,jinete.getVidaUnidad());
    }
    @Test
        // fiuba.algo3.algochess.unidades.Jinete se puede mover de a un casillero
    public void moverUnJineteNoTiraError() throws UnidadNulaException, MovimientoInvalidoException {
        Jinete jinete = new Jinete(1,1);
        jinete.moverUnidad(1,1);
    }

    @Test
        // fiuba.algo3.algochess.unidades.Jinete no se puede mover mas de un casillero
    public void movimientoInvalidoJinete(){
        Jinete jinete = new Jinete(1,1);
        try {
            jinete.moverUnidad(3,2);
        } catch (MovimientoInvalidoException | UnidadNulaException e) {
            Assertions.assertEquals("La unidad solo se mueve de a un casillero",e.getMessage());
        }
    }
}



/*
    @Test
        //El jinete puede atacar de cerca.
    public void jinetePuedeAtacarDeCerca() throws NoPuedeAtacarException, UnidadNulaException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaCerca(jinete, 0);
        Assertions.assertEquals(95,jinete.getVidaUnidad());
    }
    @Test
        //El jinete puede atacar a distancia media.
    public void jinetePuedeAtacarDistanciaMediana() throws NoPuedeAtacarException, UnidadNulaException {
        Jinete jinete = new Jinete(1,1);
        jinete.atacarDistanciaMediana(jinete, 0);
        Assertions.assertEquals(85,jinete.getVidaUnidad());
    }
    @Test
        //El jinete no puede atacar a distancia lejana.
    public void jinetePuedeAtacarDistanciaLejana() throws NoPuedeAtacarException {
        Jinete jinete = new Jinete(1,1);
        try {
            jinete.atacarDistanciaLejana(jinete, 0, arrayCasillero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El jinete no puede atacar distancias lejanas",e.getMessage());
        }
    }
    */