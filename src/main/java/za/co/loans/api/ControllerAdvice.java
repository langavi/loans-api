package za.co.loans.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.domain.exception.InvalidJwtException;
import za.co.loans.domain.exception.UnauthorisedUserException;

import java.util.Collections;

@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ValidationResponse handleUnauthorisedUserException(UnauthorisedUserException e) {
        log.error("UnauthorisedUserException exception ", e);
        return ValidationResponse.builder()
                .errors(Collections.singletonList(e.getMessage()))
                .build();
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ValidationResponse handleInvalidJwtException(InvalidJwtException e) {
        log.error("InvalidJwtException exception ", e);
        return ValidationResponse.builder()
                .errors(Collections.singletonList("Invalid JWT"))
                .build();
    }
}
