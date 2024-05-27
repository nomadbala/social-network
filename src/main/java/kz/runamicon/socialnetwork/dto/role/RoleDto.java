package kz.runamicon.socialnetwork.dto.role;

import java.io.Serializable;

public record RoleDto(
        Long id,

        String name
) implements Serializable {
}
