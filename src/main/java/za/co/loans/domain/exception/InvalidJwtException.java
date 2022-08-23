package za.co.loans.domain.exception;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException(Throwable cause) {
        super(cause);
    }

    public InvalidJwtException(String message) {
        super(message);
    }
}
