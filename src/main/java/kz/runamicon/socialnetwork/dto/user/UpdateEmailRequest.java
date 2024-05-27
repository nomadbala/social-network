package kz.runamicon.socialnetwork.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Update email request entity")
public record UpdateEmailRequest(
        @Schema(description = "Unique identifier of the user", example = "1")
        @NotNull(message = "User ID cannot be null")
        Long id,

        @Schema(description = "New email address for the user", example = "newemail@example.com")
        @NotBlank(message = "New email cannot be empty")
        @Email(message = "Email should be in format user@example.com")
        @Size(min = 5, max = 255, message = "Email should contain from 5 to 255 characters")
        String newEmail
) {
}
