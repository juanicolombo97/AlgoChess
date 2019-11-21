package fiuba.algo3.algochess.acciones;

import fiuba.algo3.algochess.excepciones.CurarException;
import fiuba.algo3.algochess.excepciones.NoPuedeAtacarException;
import fiuba.algo3.algochess.excepciones.UnidadNulaException;
import fiuba.algo3.algochess.unidades.Unidad;
import java.util.HashMap;

public class AccionesFabrica {

    public HashMap acciones = new HashMap();

    public void iniciarAccion(Unidad atacante, Unidad atacado) throws NoPuedeAtacarException, CurarException, UnidadNulaException {
        int distanciaX = atacante.getPosicion().distanciaXHasta(atacado.getPosicion());
        int distanciaY = atacante.getPosicion().distanciaYHasta(atacado.getPosicion());
        double moduloDistancia = Math.sqrt((distanciaX * distanciaX) + (distanciaY * distanciaY));

        establecerAcciones(atacante, atacado);
        Accion nuevaAccion = (Accion) acciones.get(moduloDistancia); //Quiero CASTEAR LA ACCION, nose si es correcto esto
        nuevaAccion.atacar(atacante,atacado);
    }

    public void establecerAcciones(Unidad atacante, Unidad atacado) {
        for (int distX = 0; distX <= 2; distX++) {
            for (int distY = 0; distY <= 2; distY++) {
                double moduloAux = Math.sqrt((distX * distX) + (distY * distY));
                AccionCercana accionCercana = new AccionCercana();
                this.acciones.put(moduloAux, accionCercana);
            }
        }
        for (int distX = 2; distX <= 5; distX++) {
            for (int distY = 3; distY <= 5; distY++) {
                double moduloAux = Math.sqrt((distX * distX) + (distY * distY));
                AccionMedia accionMedia = new AccionMedia();
                this.acciones.put(moduloAux, accionMedia);
            }
        }
        for (int distX = 5; distX <= 5; distX++) {
            for (int distY = 6; distY <= 20; distY++) {
                double moduloAux = Math.sqrt((distX * distX) + (distY * distY));
                AccionLejana accionLejana = new AccionLejana();
                this.acciones.put(moduloAux, accionLejana);
            }
        }
    }
}

        /*
        if((distanciaX <= 2) && (distanciaY <= 2)){
            new AccionCercana(atacante,atacado,danioExtra);
        }
        else if((distanciaX <= 5) && (distanciaY <= 5)){
            new AccionMedia(atacante,atacado,danioExtra);
        }
        else if((distanciaX >= 6) && (distanciaY >= 6)){
            new AccionLejana(atacante,atacado,danioExtra);
        }
        */