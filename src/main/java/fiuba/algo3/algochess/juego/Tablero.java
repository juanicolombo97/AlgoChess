package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.*;
import fiuba.algo3.algochess.unidades.Batallon;
import fiuba.algo3.algochess.unidades.Soldado;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadesCercanas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private Map<Posicion,Casillero> tablero = new HashMap<>();
    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException, CasilleroOcupadoException {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = this.asignarEquipo(posicion,jugador1,jugador2);
                tablero.put(posicion,casillero);
            }
        }
    }

    private Casillero asignarEquipo (Posicion posicion,Jugador jugador1, Jugador jugador2) throws UnidadInvalidaException {
        if (posicion.getPosicionX()< 10){
            Casillero casillero = new Casillero(posicion);
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero(posicion);
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public Unidad crearUnidad(Jugador jugador,Posicion posicion, String nombreUnidad) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException {
        Casillero casilleroDestino = tablero.get(posicion);
        Unidad unidadCreada = jugador.crearUnidad(casilleroDestino,nombreUnidad,posicion);
        casilleroDestino.guardarUnidad(unidadCreada);
        jugador.guardarUnidad(unidadCreada);
        return unidadCreada;
    }

    public void moverUnidad(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador) throws UnidadNulaException, UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException, CasilleroVacioExcepcion{
        Unidad unidadAMover = tablero.get(posicionInicial).obtenerUnidad();
        if (esSoldado(unidadAMover)){
            moverBatallon(unidadAMover, posicionFinal, jugador);
        } else {
            moverUnidadSolitaria(posicionInicial, posicionFinal, jugador);
        }
    }

    private void moverUnidadSolitaria(Posicion posicionInicial,Posicion posicionFinal, Jugador jugador) throws UnidadNulaException, fiuba.algo3.algochess.excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException, CasilleroVacioExcepcion {
        Casillero casilleroInicial = tablero.get(posicionInicial);
        Casillero casilleroDestino = tablero.get(posicionFinal);
        //Veo que la distancia sea correcta.
        casilleroInicial.movimientoValido(casilleroDestino);
        //Verifico que la unidad se peuda mover y que sea del jugador.
        Unidad unidadAMover = casilleroInicial.obtenerUnidad();

        jugador.unidadPerteneceAJugador(unidadAMover);
        unidadAMover.habilidadMoverse();

        casilleroDestino.guardarUnidad(unidadAMover);
        casilleroInicial.eliminarUnidad();
    }

    private void moverBatallon(Unidad unidadAMover, Posicion posicionFinal, Jugador jugador) throws UnidadNulaException, CasilleroOcupadoException, MovimientoInvalidoException, CasilleroVacioExcepcion, UnidadInvalidaException {
        Batallon batallon = new Batallon();
        ArrayList listaUnidades = batallon.calcularBatallonDeSoldados(unidadAMover, (HashMap) tablero);
        if (listaUnidades.size() < 3){
            Posicion posicionInicial = unidadAMover.getPosicion();
            moverUnidadSolitaria(posicionInicial, posicionFinal, jugador);
        } else {
            int contador = 0;
            while (listaUnidades.size() != 0 && contador != 3){
                Soldado soldado = (Soldado) listaUnidades.remove(0);
                Posicion posicionSoldado = soldado.getPosicion();
                Distancia distancia = posicionSoldado.calcularDistancia(posicionFinal);
                Posicion posicionNueva = posicionSoldado.posicionNuevaPorDistancia(distancia);
                try {
                    soldado.habilidadMoverse();
                    tablero.get(posicionNueva).guardarUnidad(soldado);
                    tablero.get(posicionSoldado).eliminarUnidad();
                    contador++;
                }catch (CasilleroOcupadoException e){
                    Unidad unidadEnElCasillero = tablero.get(posicionNueva).obtenerUnidad();
                    if (listaUnidades.contains(unidadEnElCasillero)){
                        listaUnidades.add(soldado);
                    }
                }
            }
        }
    }

    public void atacar(Posicion posicionAtacante,Posicion posicionAtacado, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, UnidadInvalidaException, CasilleroVacioExcepcion {
        Unidad unidadAtacante = tablero.get(posicionAtacante).obtenerUnidad();
        Unidad unidadAtacada = tablero.get(posicionAtacado).obtenerUnidad();
        Distancia distancia = tablero.get(posicionAtacante).calcularDistancia(posicionAtacado);
        jugador.atacar(unidadAtacante,unidadAtacada,tablero.get(posicionAtacado), (HashMap) tablero, distancia);
    }

    public ArrayList unidadesCercanasADistancia1y2(Unidad unaUnidad) throws CasilleroVacioExcepcion {
        UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
        ArrayList listaDeUnidades = new ArrayList();
        ArrayList unidadesCercanasADistancia1 = unidadesCercanas.unidadesCercanas((HashMap) tablero, listaDeUnidades, unaUnidad, 1);
        ArrayList unidadesCercanasADistancia2 = unidadesCercanas.unidadesCercanas((HashMap) tablero, listaDeUnidades, unaUnidad, 2);
        for(Object unidadActual : unidadesCercanasADistancia2){
            if (!unidadesCercanasADistancia1.contains(unidadActual)){
                unidadesCercanasADistancia1.add(unidadActual);
            }
        }
        return unidadesCercanasADistancia1;
    }

    public void notificar(Unidad unidadEmisora) throws CasilleroVacioExcepcion {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidadEmisora);
        for(Object unidadActual : unidadesCercanas){
            Unidad unidad = (Unidad) unidadActual;
            unidad.recibirNotificacion();
        }
    }

    public void unidadesAliadasCercanasPorJugador(Jugador jugador, ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanas){
        for(Object unidad : unidadesCercanas){
            Unidad unidadActual = (Unidad) unidad;
            if (jugador.unidadAliada(unidadActual)){
                unidadesAliadasCercanas.add(unidadActual);
            }
        }
    }

    public ArrayList unidadesAliadasCercanas(Unidad unidad) throws CasilleroVacioExcepcion {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesAliadasCercanasAUnidad = new ArrayList();
        if (this.jugador1.unidadAliada(unidad)){
            unidadesAliadasCercanasPorJugador(jugador1, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        } else {
            unidadesAliadasCercanasPorJugador(jugador2, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        }
        return unidadesAliadasCercanasAUnidad;
    }

    public int cantidadSoldadosAliadosCercanos(Unidad unidad) throws CasilleroVacioExcepcion {
        ArrayList soldadosAliadosCercanos = new ArrayList();
        ArrayList unidadesAliadasCercanasAUnidad = unidadesAliadasCercanas(unidad);
        for (Object unidadActual: unidadesAliadasCercanasAUnidad){
            if (((Unidad)unidadActual).sosSoldado()){
                soldadosAliadosCercanos.add(unidadActual);
            }
        }
        return soldadosAliadosCercanos.size();
    }

    public ArrayList unidadesEnemigasCercanas(Unidad unidad) throws CasilleroVacioExcepcion {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesEnemigasCercanasAUnidad = new ArrayList();
        if (this.jugador1.unidadAliada(unidad)){
            unidadesAliadasCercanasPorJugador(jugador2, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        } else {
            unidadesAliadasCercanasPorJugador(jugador1, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        }
        return unidadesEnemigasCercanasAUnidad;
    }

    private boolean esSoldado(Unidad unidad){
       return unidad.sosSoldado();
    }
}
