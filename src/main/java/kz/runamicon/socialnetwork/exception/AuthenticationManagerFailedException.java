package kz.runamicon.socialnetwork.exception;

public class AuthenticationManagerFailedException extends RuntimeException {
    public AuthenticationManagerFailedException(String message) {
        super(message);
    }

    public AuthenticationManagerFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
