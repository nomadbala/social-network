package kz.runamicon.socialnetwork.dto.user;

public record UpdateEmailRequest(
        Long id,
        String newEmail
) {
}
