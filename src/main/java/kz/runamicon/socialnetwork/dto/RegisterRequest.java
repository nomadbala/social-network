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
@Schema(description = "Registration request entity")
public class RegisterRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "Registration request login", example = "johndoe23")
    private String login;

    @Schema(description = "Registration request username", example = "John Doe")
    private String username;

    @Schema(description = "Registration request password", example = "Pass123!@")
    private String password;

    @Schema(description = "Registration request email", example = "example@mail.com")
    private String email;
}
