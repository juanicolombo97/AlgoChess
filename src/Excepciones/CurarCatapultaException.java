package Excepciones;

public class CurarCatapultaException extends Exception{
    String errorCatapulta = "No se puese curar a una catapulta";
    @Override
    public String getMessage(){
        return errorCatapulta;
    }
}
