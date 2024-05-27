package kz.runamicon.socialnetwork.dto;

public record UpdateEmailRequest(
        Long id,
        String newEmail
) {
}
