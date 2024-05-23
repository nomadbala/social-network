package kz.runamicon.socialnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Registration request entity")
public record RegisterRequest(
        @Schema(description = "Registration request login", example = "johndoe23")
        String login,

        @Schema(description = "Registration request username", example = "John Doe")
        String username,

        @Schema(description = "Registration request password", example = "Pass123!@")
        String password,

        @Schema(description = "Registration request email", example = "example@mail.com")
        String email
) implements Serializable {

}