package kz.runamicon.socialnetwork.dto.authentication;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "Registration request entity")
public record RegisterRequest(
        @Schema(description = "Registration request login", example = "johndoe23")
        @Size(min = 5, max = 50, message = "User`s login should contain from 5 to 50 symbols")
        @NotBlank(message = "User`s login can`t be empty")
        String login,

        @Schema(description = "Registration request username", example = "John Doe")
        @Size(min = 5, max = 50, message = "User`s username should contain from 5 to 50 symbols")
        @NotBlank(message = "User`s username can`t be empty")
        String username,

        @Schema(description = "Registration request password", example = "Pass123!@")
        @Size(max = 255, message = "Password length must be no more than 255 characters")
        String password,

        @Schema(description = "Registration request email", example = "example@mail.com")
        @Size(min = 5, max = 255, message = "User`s email should contain from 5 to 255 symbols")
        @NotBlank(message = "User`s email can`t be empty")
        @Email(message = "Email should be in format user@example.com")
        String email
) implements Serializable {

}