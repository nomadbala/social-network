package kz.runamicon.socialnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Authorization request entity")
public record LoginRequest(
        @Schema(description = "Login request username", example = "John Doe")
        String login,

        @Schema(description = "Login request password", example = "Pass123!@")
        String password
) implements Serializable {
}
