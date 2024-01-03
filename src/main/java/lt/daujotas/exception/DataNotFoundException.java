package lt.daujotas.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException() {
        super("DB data not found by criteria");
    }
}
