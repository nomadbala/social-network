package kz.runamicon.socialnetwork.dto.user;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import kz.runamicon.socialnetwork.dto.role.RoleDto;

import java.io.Serializable;
import java.util.Set;

@Schema(description = "User Data Transfer Object")
public record UserDto(
        @Schema(description = "Unique identifier of the user", example = "1")
        Long id,

        @Schema(description = "User login", example = "johndoe23")
        String login,

        @Schema(description = "User email", example = "johndoe@example.com")
        String email,

        @Schema(description = "User password", example = "Pass123!@")
        String password,

        @Schema(description = "User's full name", example = "John Doe")
        String username,

        @ArraySchema(schema = @Schema(description = "Roles assigned to the user", implementation = RoleDto.class))
        Set<RoleDto> roles
) implements Serializable {
}
