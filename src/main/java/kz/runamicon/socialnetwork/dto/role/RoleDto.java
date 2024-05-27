package kz.runamicon.socialnetwork.dto.role;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Role Data Transfer Object")
public record RoleDto(
        @Schema(description = "Unique identifier of the role", example = "1")
        Long id,

        @Schema(description = "Name of the role", example = "ADMIN")
        String name
) implements Serializable {
}
