package kz.runamicon.socialnetwork.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Update user`s username request entity")
public record UpdateUsernameRequest(
        @Schema(description = "User`s id", example = "1")
        Long id,

        @Schema(description = "User`s new username",  example = "Katrina Barret")
        String username
) implements Serializable {
}
