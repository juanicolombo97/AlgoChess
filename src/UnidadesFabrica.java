import excepciones.UnidadInvalidaException;

import java.util.Hashtable;

public class UnidadesFabrica {

    //Fabrica utilizada para crear las unidades del juego.
    private Hashtable unidades = new Hashtable();

    public Unidad crearUnidad(String unidad, int posicionX, int posicionY) throws UnidadInvalidaException {
        // establesco las unidades posibles
        establecerUnidades(posicionX,posicionY);
        return (Unidad) unidades.get(unidad.toLowerCase());

    }

    public void establecerUnidades(int posX, int posY){
        Soldado soldado = new Soldado(posX,posY);
        Catapulta catapulta = new Catapulta(posX,posY);
        Jinete jinete = new Jinete(posX,posY);
        Curandero curandero = new Curandero(posX,posY);
        UnidadNula unidadNula = new UnidadNula(posX,posY);

        unidades.put("soldado",soldado);
        unidades.put("catapulta",catapulta);
        unidades.put("jinete",jinete);
        unidades.put("curandero",curandero);
        unidades.put("",unidadNula);
    }
}
