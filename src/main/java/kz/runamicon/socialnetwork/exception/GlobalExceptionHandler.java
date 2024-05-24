package kz.runamicon.socialnetwork.exception;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUserNotFoundException(UserNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRoleNotFoundException(RoleNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleAuthenticationFailedException(AuthenticationFailedException e) {
        return e.getMessage();
    }

    @ExceptionHandler(RegistrationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRegistrationFailedException(RegistrationFailedException e) {
        return e.getMessage();
    }

    @ExceptionHandler(SecurityFilterChainInitializationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleSecurityFilterChainInitializationException(SecurityFilterChainInitializationException e) {
        return e.getMessage();
    }

    @ExceptionHandler(AuthenticationManagerFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAuthenticationManagerFailedException(AuthenticationManagerFailedException e) {
        return e.getMessage();
    }
}
