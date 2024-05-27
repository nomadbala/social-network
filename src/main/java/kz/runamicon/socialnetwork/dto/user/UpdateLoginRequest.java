package kz.runamicon.socialnetwork.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "Update login request entity")
public record UpdateLoginRequest(
        @Schema(description = "Unique identifier of the user", example = "1")
        @NotNull(message = "User ID cannot be null")
        Long id,

        @Schema(description = "New login for the user", example = "newlogin123")
        @NotBlank(message = "New login cannot be empty")
        @Size(min = 5, max = 50, message = "Login should contain from 5 to 50 characters")
        String newLogin
) implements Serializable {
}
