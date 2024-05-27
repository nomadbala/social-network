package kz.runamicon.socialnetwork.dto.security;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Jwt authentication token")
public record JwtAuthenticationToken(
        @Schema(description = "Access token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
        String token
) implements Serializable {
}
