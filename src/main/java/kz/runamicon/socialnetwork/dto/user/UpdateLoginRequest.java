package kz.runamicon.socialnetwork.dto.user;

import java.io.Serializable;

public record UpdateLoginRequest(
        Long id,

        String newLogin
) implements Serializable {
}
