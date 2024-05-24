package kz.runamicon.socialnetwork.exception;

public class SecurityFilterChainInitializationException extends RuntimeException {
    public SecurityFilterChainInitializationException(String message) {
        super(message);
    }

    public SecurityFilterChainInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
