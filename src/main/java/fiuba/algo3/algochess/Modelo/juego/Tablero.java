package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.unidades.*;

import java.util.*;
import java.util.stream.Collectors;

public class Tablero {
    private Map<Posicion,Casillero> tablero = new HashMap<>();
    private Jugador jugador1;
    private Jugador jugador2;
    private Emisario emisario = new EmisarioActivo(this);


    public Tablero(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = new Casillero(posicion,jugador1);
                tablero.put(posicion,casillero);
            }
        }
        filterCasilleros();
    }


    public void filterCasilleros(){

        List casillerosAliados = tablero.entrySet().stream()
                                                    .filter(map -> map.getKey().posicionX < 10)
                                                    .map(Map.Entry :: getValue)
                                                    .collect(Collectors.toList());
        jugador1.casillerosAliados(casillerosAliados);

        List casillerosEnemigos = tablero.entrySet().stream().filter(map -> map.getKey().posicionX >= 10)
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
                jugador.unidadModificarPosicionCasillero(unidad,casilleroFin);
                casilleroInicio.eliminarUnidad();
                contador++;
            }catch (CasilleroOcupadoException e){
            }
        }
    }

    public void atacar(Posicion posicionAtacante,Posicion posicionAtacado, Jugador jugador) {
        Unidad unidadAtacante = tablero.get(posicionAtacante).obtenerUnidad();
        Unidad unidadAtacada = tablero.get(posicionAtacado).obtenerUnidad();
        Distancia distancia = tablero.get(posicionAtacante).calcularDistancia(posicionAtacado);
        jugador.atacar(unidadAtacante,unidadAtacada,tablero.get(posicionAtacado), (HashMap) tablero,distancia);
    }

    public HashMap getTablero(){
        return (HashMap) tablero;
    }


    public void notificar(Unidad unidadEmisora) { //done
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidadEmisora);
        for(int i = 0; i < unidadesCercanas.size(); i++){
            Unidad unidadActual = (Unidad) unidadesCercanas.get(i);
            unidadActual.recibirNotificacion();
        }
    }

    public ArrayList unidadesCercanasADistancia1y2(Unidad unaUnidad) { // done
        UnidadesCercanas unidadesCercanas = new UnidadesCercanas();
        ArrayList unidadesADistanciaCercana = unidadesCercanas.unidadesCercanasADistancia(2,(HashMap) tablero, unaUnidad);
        return unidadesADistanciaCercana;
    }


    public ArrayList unidadesAliadasCercanas(Unidad unidad) { //done
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesAliadasCercanasAUnidad = new ArrayList();
        this.jugador1.reconocerUnidadesAliadasCercanasA(unidad, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        this.jugador2.reconocerUnidadesAliadasCercanasA(unidad, unidadesCercanas, unidadesAliadasCercanasAUnidad);
        return unidadesAliadasCercanasAUnidad;
    }

    public int cantidadSoldadosAliadosCercanos(Unidad unidad) { //done
        ArrayList soldadosAliadosCercanos = new ArrayList();
        ArrayList unidadesAliadasCercanasAUnidad = unidadesAliadasCercanas(unidad);
        for (Object unidadActual: unidadesAliadasCercanasAUnidad){
            Unidad laUnidadActual = (Unidad)unidadActual;
            laUnidadActual.agregarSoldadoAListaDeSoldados(soldadosAliadosCercanos);
        }
        return soldadosAliadosCercanos.size();
    }

    public ArrayList unidadesEnemigasCercanas(Unidad unidad) {
        ArrayList unidadesCercanas = unidadesCercanasADistancia1y2(unidad);
        ArrayList unidadesEnemigasCercanasAUnidad = new ArrayList();
        this.jugador1.reconocerUnidadesEnemigasCercanasA(unidad, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        this.jugador2.reconocerUnidadesEnemigasCercanasA(unidad, unidadesCercanas, unidadesEnemigasCercanasAUnidad);
        return unidadesEnemigasCercanasAUnidad;
    }
}
