package kz.runamicon.socialnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Jwt authentication token")
public record JwtAuthenticationToken(
        @Schema(description = "Access token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
        String token
) {
}
