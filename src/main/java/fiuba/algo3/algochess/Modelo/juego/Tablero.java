package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.unidades.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private Map<Posicion,Casillero> tablero = new HashMap<>();
    private Jugador jugador1;
    private Jugador jugador2;
    private Emisario emisario = new EmisarioActivo(this);
    private boolean casilleroAliado = true;
    private boolean casilleroEnemigo = false;

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
            Casillero casillero = new Casillero(posicion,casilleroAliado);
;           jugador1.agregarCasillero(casillero);
            return casillero;
        } else {
            Casillero casillero = new Casillero(posicion,casilleroEnemigo);
            jugador2.agregarCasillero(casillero);
            return casillero;
        }
    }

    public Unidad crearUnidad(Jugador jugador,Posicion posicion, String nombreUnidad) throws NoAlcanzanLosPuntosException, UnidadInvalidaException, CasilleroEnemigoException, CasilleroOcupadoException, MovimientoInvalidoException, CasilleroVacioExcepcion {
        Casillero casilleroDestino = tablero.get(posicion);
        Unidad unidadCreada = jugador.crearUnidad(casilleroDestino,nombreUnidad,posicion,this.emisario);
        casilleroDestino.guardarUnidad(unidadCreada);
        jugador.guardarUnidad(unidadCreada);
        emisario.notificar(unidadCreada);
        return unidadCreada;
    }

    public void moverUnidad(Posicion posicionInicial,Posicion posicionFinal, Jugador jugador) throws UnidadNulaException, fiuba.algo3.algochess.Modelo.excepciones.UnidadInvalidaException, MovimientoInvalidoException, CasilleroOcupadoException, CasilleroVacioExcepcion {

        int contador = 0;
        Casillero casilleroInicial = tablero.get(posicionInicial);
        Casillero casilleroDestino = tablero.get(posicionFinal);
        Distancia distancia = posicionInicial.calcularDistanciaConDireccion(posicionFinal);
        Direccion direccionMovimiento = new Direccion(distancia.getDistanciaX(),distancia.getDistanciaY());

        //Veo que la distancia sea correcta.
        casilleroInicial.movimientoValido(casilleroDestino);
        //Verifico que la unidad se peuda mover y que sea del jugador.
        Unidad unidadAMover = casilleroInicial.obtenerUnidad();
        ArrayList listaUnidadesAliadas = jugador.getUnidadesDisponibles();
        ArrayList listaUnidadesAMover = unidadAMover.habilidadMoverse(unidadAMover, (HashMap) tablero,listaUnidadesAliadas);
        while (contador != 3 && listaUnidadesAMover.size() != 0){
            Unidad unidad = (Unidad) listaUnidadesAMover.remove(0);
            jugador.unidadPerteneceAJugador(unidad);
            Posicion posicion = unidad.getPosicion();
            Posicion posicionDestino = posicion.posicionNueva(direccionMovimiento);
            Casillero casilleroInicio = tablero.get(posicion);
            Casillero casilleroFin = tablero.get(posicionDestino);
            try {
                casilleroFin.guardarUnidad(unidad);
                casilleroInicio.eliminarUnidad();
                contador++;
            }catch (CasilleroOcupadoException e){
            }
        }
    }

    public void atacar(Posicion posicionAtacante,Posicion posicionAtacado, Jugador jugador) throws NoPuedeAtacarException, UnidadNulaException, CurarException, UnidadInvalidaException, CasilleroVacioExcepcion {
        Unidad unidadAtacante = tablero.get(posicionAtacante).obtenerUnidad();
        Unidad unidadAtacada = tablero.get(posicionAtacado).obtenerUnidad();
        Distancia distancia = tablero.get(posicionAtacante).calcularDistancia(posicionAtacado);
        if (jugador1.unidadAliada(unidadAtacante) && (tablero.get(unidadAtacada.getPosicion()).esCasilleroAliado()){

        }
        jugador.atacar(unidadAtacante,unidadAtacada,tablero.get(posicionAtacado), (HashMap) tablero,distancia);
    }

    public HashMap getTablero(){
        return (HashMap) tablero;
    }



    public void notificar(Unidad unidadEmisora) throws CasilleroVacioExcepcion {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidadEmisora);
        for(int i = 0; i < unidadesCercanas.size(); i++){
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            unidadActual.recibirNotificacion();
        }
    }

    public ArrayList unidadesCercanasADistancia1y2(Unidad unaUnidad) throws CasilleroVacioExcepcion {
        UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
        ArrayList unidadesADistanciaCercana = unidadesCercanas.unidadesCercanasADistancia(2,(HashMap) tablero, unaUnidad);
        if (unidadesADistanciaCercana.contains(unaUnidad)){
            unidadesADistanciaCercana.remove(unaUnidad);
        }
        return unidadesADistanciaCercana;
    }

    public void unidadesAliadasCercanasPorJugador(Jugador jugador, ArrayList unidadesCercanas, ArrayList unidadesAliadasCercanas){

        for(int i = 0; i < unidadesCercanas.size(); i++) {
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            if (jugador.unidadAliada(unidadActual)) {
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
            Unidad laUnidadActual = (Unidad)unidadActual;
            if (laUnidadActual.esSoldado()){
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
}
