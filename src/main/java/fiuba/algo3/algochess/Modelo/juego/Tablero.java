package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.unidades.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Tablero {
    private Map<Posicion,Casillero> tablero = new HashMap<>();
    private Jugador jugador1;
    private Jugador jugador2;
    private Emisario emisario;


    public Tablero(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = new Casillero(posicion);
                tablero.put(posicion,casillero);
            }
        }
        emisario = new EmisarioActivo(this);
        filterCasilleros();
    }


    public void filterCasilleros(){

        List<Casillero> casillerosAliados = tablero.entrySet().stream()
                                                    .filter(map -> map.getKey().posicionX < 10)
                                                    .map(Map.Entry :: getValue)
                                                    .collect(Collectors.toList());
        jugador1.casillerosAliados(casillerosAliados);

        List<Casillero> casillerosEnemigos = tablero.entrySet().stream().filter(map -> map.getKey().posicionX >= 10)
                                                                .map(Map.Entry :: getValue)
                                                                .collect(Collectors.toList());
        jugador2.casillerosAliados(casillerosEnemigos);
    }

    public Unidad crearUnidad(Jugador jugador,Posicion posicion, String nombreUnidad) {
        Casillero casilleroDestino = tablero.get(posicion);
        Unidad unidadCreada = jugador.crearUnidad(casilleroDestino,nombreUnidad,posicion,this.emisario);
        jugador.guardarUnidad(unidadCreada);
        casilleroDestino.guardarUnidad(unidadCreada);
        jugador.modificarPuntos(unidadCreada);
        emisario.notificar(unidadCreada);
        return unidadCreada;
    }

    public void moverUnidad(Posicion posicionInicial,Posicion posicionFinal, Jugador jugador) {

        AtomicInteger contador = new AtomicInteger(0);
        Casillero casilleroInicial = tablero.get(posicionInicial);
        Casillero casilleroDestino = tablero.get(posicionFinal);
        Distancia distancia = posicionInicial.calcularDistanciaConDireccion(posicionFinal);
        Direccion direccionMovimiento = distancia.direccionMovimiento();

        //Veo que la distancia sea correcta.
        casilleroInicial.movimientoValido(casilleroDestino);
        //Verifico que la unidad se peuda mover y que sea del jugador.
        Unidad unidadAMover = casilleroInicial.obtenerUnidad();
        List<Unidad> listaUnidadesAliadas = jugador.getUnidadesDisponibles();
        List<Unidad> listaUnidadesAMover = unidadAMover.habilidadMoverse(unidadAMover, tablero,listaUnidadesAliadas);
        while (contador.get() != 3 && listaUnidadesAMover.size() != 0){
            Unidad unidad = listaUnidadesAMover.remove(0);
            jugador.unidadPerteneceAJugador(unidad);
            Posicion posicion = unidad.getPosicion();
            Posicion posicionDestino = posicion.posicionNueva(direccionMovimiento);
            Casillero casilleroInicio = tablero.get(posicion);
            Casillero casilleroFin = tablero.get(posicionDestino);
            casilleroFin.guardarUnidadCercana(unidad,jugador,casilleroInicio,contador);
        }
    }

    public Casillero atacar(Posicion posicionAtacante,Posicion posicionAtacado, Jugador jugador) {
        Unidad unidadAtacante = tablero.get(posicionAtacante).obtenerUnidad();
        Unidad unidadAtacada = tablero.get(posicionAtacado).obtenerUnidad();
        Distancia distancia = tablero.get(posicionAtacante).calcularDistancia(posicionAtacado);
        jugador.atacar(unidadAtacante,unidadAtacada,tablero.get(posicionAtacado), tablero,distancia);
        Casillero casilleroAtacado = tablero.get(posicionAtacado);
        return casilleroAtacado;
    }

    public Map<Posicion, Casillero> getTablero(){
        return tablero;
    }


    public void notificar(Unidad unidadEmisora) { //done
        List<Unidad> unidadesCercanas = unidadesCercanasADistancia1y2(unidadEmisora);
        for(Unidad unidadActual : unidadesCercanas){
            unidadActual.recibirNotificacion();
        }
    }

    public List<Unidad> unidadesCercanasADistancia1y2(Unidad unaUnidad) { // done
        UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
        return unidadesCercanas.unidadesCercanasADistancia(2, tablero, unaUnidad);
    }


    public List<Unidad> unidadesAliadasCercanas(Unidad unidad) { //done
        List<Unidad> unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        List<Unidad> unidadesAliadasCercanasAUnidad = new ArrayList<>();
        this.jugador1.reconocerUnidadesAliadasCercanasA(unidad, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        this.jugador2.reconocerUnidadesAliadasCercanasA(unidad, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        return unidadesAliadasCercanasAUnidad;
    }

    public int cantidadSoldadosAliadosCercanos(Unidad unidad) { //done
        List<Unidad> soldadosAliadosCercanos = new ArrayList<>();
        List<Unidad> unidadesAliadasCercanasAUnidad = unidadesAliadasCercanas(unidad);
        for (Unidad unidadActual: unidadesAliadasCercanasAUnidad){
            unidadActual.agregarSoldadoAListaDeSoldados(soldadosAliadosCercanos);
        }
        return soldadosAliadosCercanos.size();
    }

    public List<Unidad> unidadesEnemigasCercanas(Unidad unidad) {
        List<Unidad> unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        List<Unidad> unidadesEnemigasCercanasAUnidad = new ArrayList<>();
        this.jugador1.reconocerUnidadesEnemigasCercanasA(unidad, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        this.jugador2.reconocerUnidadesEnemigasCercanasA(unidad, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        return unidadesEnemigasCercanasAUnidad;
    }
}
