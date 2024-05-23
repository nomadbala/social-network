package kz.runamicon.socialnetwork.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super("Role %s not found".formatted(message));
    }
}
