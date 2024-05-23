package kz.runamicon.socialnetwork.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super("User with username %s not found".formatted(message));
    }
}
