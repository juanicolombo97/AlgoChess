package fiuba.algo3.algochess.unidades;

import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;

import java.util.Hashtable;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.
    private Hashtable unidades = new Hashtable();

    public Unidad crearUnidad(String unidad, int posicionX, int posicionY, Emisario emisario) throws UnidadInvalidaException {
        // establesco las unidades posibles
        establecerUnidades(posicionX,posicionY, emisario);
        return (Unidad) unidades.get(unidad.toLowerCase());

    }

    public void establecerUnidades(int posX, int posY, Emisario emisario){
        Soldado soldado = new Soldado(posX,posY, emisario);
        Catapulta catapulta = new Catapulta(posX,posY, emisario);
        Jinete jinete = new Jinete(posX,posY, emisario);
        Curandero curandero = new Curandero(posX,posY, emisario);
        UnidadNula unidadNula = new UnidadNula(posX,posY, emisario);

        unidades.put("soldado",soldado);
        unidades.put("catapulta",catapulta);
        unidades.put("jinete",jinete);
        unidades.put("curandero",curandero);
        unidades.put("",unidadNula);
    }
}
