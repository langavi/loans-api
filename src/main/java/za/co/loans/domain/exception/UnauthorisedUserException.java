package za.co.loans.domain.exception;

public class UnauthorisedUserException extends RuntimeException {

    public UnauthorisedUserException(String message) {
        super(message);
    }
}
