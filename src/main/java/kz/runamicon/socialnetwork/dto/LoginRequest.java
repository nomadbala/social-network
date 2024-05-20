package kz.runamicon.socialnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Authorization request entity")
public class LoginRequest implements Serializable {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "Login request username", example = "John Doe")
    private String login;

    @Schema(description = "Login request password", example = "Pass123!@")
    private String password;
}
