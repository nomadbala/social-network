package kz.runamicon.socialnetwork.dto;

import java.io.Serializable;
import java.util.Set;

public record UserDto(
        Long id,

        String login,

        String email,

        String password,

        String username,

        Set<RoleDto> roles
) implements Serializable {
}
