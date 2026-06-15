package exceptions;

public class OutOfCapacity extends RuntimeException {
    public OutOfCapacity(String message) {
        super(message);
    }
}
