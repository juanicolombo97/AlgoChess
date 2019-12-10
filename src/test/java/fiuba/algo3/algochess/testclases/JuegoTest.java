package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Juego;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JuegoTest {

    @Test
    void jugadorCorrectoPuedeCrearUnidad(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        juego.crearUnidad("soldado",posicion);
        int tamanio = juego.jugadorAliado.getUnidadesDisponibles().size();
        Assertions.assertEquals(1,tamanio);
    }

    @Test
    void jugadorIncorrectoNoPuedeCrearUnidad(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(10,10);
        try {
            juego.crearUnidad("soldado",posicion);
        }catch (CasilleroEnemigoException e){
            Assertions.assertEquals("El casillero pertenece al enemigo",e.getMessage());
        }
    }

    @Test
    void jugadorNoPuedeCrearUnidadesSiNoAlcanzanPuntos(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(5,1);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("soldado",posicion3);

        try {
            juego.crearUnidad("catapulta",posicion4);
        }catch (NoAlcanzanLosPuntosException e){
            Assertions.assertEquals("Puntos insuficientes, dispone de: 4",e.getMessage());
        }

    }

    @Test
    void jugadorAliadoNoPuedeCrearFichasEnTerritorioEnemigo(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(11,11);
        try {
            juego.crearUnidad("soldado",posicion);
        }catch (CasilleroEnemigoException e){
            Assertions.assertEquals("El casillero pertenece al enemigo",e.getMessage());
        }
    }

    @Test
    void jugadorGastaTodosLosPuntosYAhoraEsTurnoDeEnemgio(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(15,11);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("soldado",posicion4);

        int cantidadUnidadesEnemgio = juego.jugadorEnemigo.getUnidadesDisponibles().size();
        Assertions.assertEquals(1,cantidadUnidadesEnemgio);
    }

    @Test
    void jugadorEnemigoGastaPuntosYNoSePuedeColocarMasFichas(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(10,10);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("soldado",posicion4);

        int cantidadUnidadesEnemgio = juego.jugadorEnemigo.getUnidadesDisponibles().size();
        Assertions.assertEquals(1,cantidadUnidadesEnemgio);
    }

    @Test
    void jugadorEnemigoNoPuedeColocarPiezasEnCasilleroAliado(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(2,2);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        try {
            juego.crearUnidad("soldado",posicion4);
        }catch (CasilleroEnemigoException e){
            Assertions.assertEquals("El casillero pertenece al enemigo",e.getMessage());
        }
    }

    @Test
    void jugadorAliadoNoPuedePonerEnCasilleroOcupado(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        juego.crearUnidad("soldado",posicion);
        try {
            juego.crearUnidad("soldado",posicion);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }
    @Test
    void jugadorEnemigoNoPuedeColocarPiezasEnCasilleroOcupado(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(12,12);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("soldado",posicion4);
        try {
            juego.crearUnidad("soldado",posicion4);
        }catch (CasilleroOcupadoException e){
            Assertions.assertEquals("El casillero se encuentra ocupado",e.getMessage());
        }
    }

    @Test
    void terminaFaseCreacionFichasYJugadorAliadoPuedeMover(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(10,10);
        Posicion posicion5 = new Posicion(12,11);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(14,11);
        Posicion posicion8 = new Posicion(2,2);
        Posicion posicion9 = new Posicion(5,5);
        Posicion posicion11 = new Posicion(5,6);

        juego.crearUnidad("soldado",posicion11);
        juego.crearUnidad("soldado",posicion);
        juego.crearUnidad("jinete",posicion9);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.mover(posicion,posicion8);

        Unidad unidad = juego.jugadorAliado.getUnidadesDisponibles().get(1);
        int xFinal = unidad.getPosicion().posicionX;
        int yFinal = unidad.getPosicion().posicionY;
        Posicion posicion10 = new Posicion(xFinal,yFinal);
        Assertions.assertEquals(posicion10,posicion8);


    }
    @Test
    void terminaFaseCreacionFichasYJugadorAliadoNoPuedeMoverFichasEnemigas(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,1);
        Posicion posicion2 = new Posicion(3,1);
        Posicion posicion3 = new Posicion(4,1);
        Posicion posicion4 = new Posicion(10,10);
        Posicion posicion5 = new Posicion(12,11);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(14,11);
        Posicion posicion8 = new Posicion(12,10);
        Posicion posicion9 = new Posicion(17,17);
        Posicion posicion11 = new Posicion(15,11);


        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("catapulta",posicion1);
        juego.crearUnidad("catapulta",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("soldado",posicion7);
        juego.crearUnidad("soldado",posicion8);
        juego.crearUnidad("jinete",posicion9);
        try {
            juego.mover(posicion7,posicion11);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("Unidad pertenece al enemigo",e.getMessage());
        }

    }

    @Test
    void aliadoMueveFichaYAlMoverDenuevoLanzaErrorPorqueEsTurnoEnemigo(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion10 = new Posicion(2,3);
        Posicion posicion11 = new Posicion(3,4);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("catapulta",posicion8);

        juego.mover(posicion1,posicion10);
        try {
            juego.mover(posicion2,posicion11);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("Unidad pertenece al enemigo",e.getMessage());
        }
    }

    @Test
   void enemigoPuedeMoverFichasUnaVesQueAliadoEliga(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);
        Posicion posicion10 = new Posicion(2,3);
        Posicion posicion11 = new Posicion(15,15);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.mover(posicion1,posicion10);
        juego.mover(posicion9,posicion11);

        Unidad unidadMovida = juego.jugadorEnemigo.getUnidadesDisponibles().get(4);
        int x = unidadMovida.getPosicion().posicionX;
        int y = unidadMovida.getPosicion().posicionY;
        Posicion posicionResultante = new Posicion(x,y);
        Assertions.assertEquals(posicionResultante,posicion11);
    }
    @Test
    void sistemaDeTurnorAndaCorrectamente(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);
        Posicion posicion10 = new Posicion(2,3);
        Posicion posicion11 = new Posicion(3,4);
        Posicion posicion12 = new Posicion(14,15);
        Posicion posicion13 = new Posicion(13,14);


        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.mover(posicion1,posicion10);
        juego.mover(posicion9,posicion12);
        juego.mover(posicion2,posicion11);
        juego.mover(posicion8,posicion13);

        Unidad unidadMovida = juego.jugadorEnemigo.getUnidadesDisponibles().get(3);
        int x = unidadMovida.getPosicion().posicionX;
        int y = unidadMovida.getPosicion().posicionY;
        Posicion posicionResultante = new Posicion(x,y);
        Assertions.assertEquals(posicionResultante,posicion13);
    }

    @Test
    void jugadorAliadoPuedeAtacarEnSuTurno(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.atacar(posicion,posicion5);

        Unidad unidadAtacada = juego.jugadorEnemigo.getUnidadesDisponibles().get(0);
        double vidaUnidad = unidadAtacada.getVidaUnidad();
        Assertions.assertEquals(30,vidaUnidad);

    }
    @Test
    void jugadorAliadoNoPuedeAtacarEnTurnoEnemigo(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.atacar(posicion,posicion5);
        try {
            juego.atacar(posicion,posicion5);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("Unidad pertenece al enemigo",e.getMessage());
        }

    }
    @Test
    void jugadorEnemigoPuedeAtacarEnSuTurno(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.atacar(posicion,posicion5);
        juego.atacar(posicion5,posicion);

        Unidad unidadAtacada = juego.jugadorAliado.getUnidadesDisponibles().get(0);
        double vidaUnidad = unidadAtacada.getVidaUnidad();
        Assertions.assertEquals(30,vidaUnidad);

    }
    @Test
    void jugadorEnemigoNoPuedeAtacarEnTurnoAliado(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        juego.atacar(posicion,posicion5);
        juego.atacar(posicion5,posicion);
        try {
            juego.atacar(posicion5,posicion);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("Unidad pertenece al enemigo",e.getMessage());
        }

    }

    @Test
    void jugadorEnemigoSeQuedaSinPiezasPierde(){
        Juego juego = new Juego("juani","carlos");
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(3,3);
        Posicion posicion3 = new Posicion(4,4);
        Posicion posicion4 = new Posicion(5,5);
        Posicion posicion5 = new Posicion(10,10);
        Posicion posicion6 = new Posicion(11,11);
        Posicion posicion7 = new Posicion(12,12);
        Posicion posicion8 = new Posicion(13,13);
        Posicion posicion9 = new Posicion(14,14);

        juego.crearUnidad("catapulta",posicion);
        juego.crearUnidad("curandero",posicion1);
        juego.crearUnidad("jinete",posicion2);
        juego.crearUnidad("catapulta",posicion3);
        juego.crearUnidad("catapulta",posicion4);
        juego.crearUnidad("catapulta",posicion5);
        juego.crearUnidad("catapulta",posicion6);
        juego.crearUnidad("catapulta",posicion7);
        juego.crearUnidad("curandero",posicion8);
        juego.crearUnidad("jinete",posicion9);

        //Simulo ataques sacando vida manuelmente dejando 20 al jinete de Enemigo

        Unidad unidad0 = juego.jugadorEnemigo.getUnidadesDisponibles().get(0);
        unidad0.recibirDanio(50);
        Unidad unidad1 = juego.jugadorEnemigo.getUnidadesDisponibles().get(1);
        unidad1.recibirDanio(50);
        Unidad unidad2 = juego.jugadorEnemigo.getUnidadesDisponibles().get(2);
        unidad2.recibirDanio(50);
        Unidad unidad3 = juego.jugadorEnemigo.getUnidadesDisponibles().get(3);
        unidad3.recibirDanio(75);
        Unidad unidad4 = juego.jugadorEnemigo.getUnidadesDisponibles().get(4);
        unidad4.recibirDanio(80);

            juego.atacar(posicion,posicion9);
            System.out.println(juego.jugadorEnemigo.getUnidadesDisponibles().size());

    }

}
