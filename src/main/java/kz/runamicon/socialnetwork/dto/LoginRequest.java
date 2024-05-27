package kz.runamicon.socialnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "Authorization request entity")
public record LoginRequest(
        @Schema(description = "Login request username", example = "John Doe")
        @Size(min = 5, max = 50, message = "User`s login should contain from 5 to 50 symbols")
        @NotBlank(message = "User`s login can`t be empty")
        String login,

        @Schema(description = "Login request password", example = "Pass123!@")
        @Size(max = 255, message = "Password length must be no more than 255 characters")
        String password
) implements Serializable {
}
