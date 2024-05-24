package kz.runamicon.socialnetwork.dto;

import java.io.Serializable;

public record RoleDto(
        Long id,

        String name
) implements Serializable {
}
