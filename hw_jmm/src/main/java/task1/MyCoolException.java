package task1;

public class MyCoolException extends Exception{


    public MyCoolException(String errorMessage) {
        super(errorMessage);
    }

    public MyCoolException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public MyCoolException(Throwable err) {
        super(err);
    }

}
