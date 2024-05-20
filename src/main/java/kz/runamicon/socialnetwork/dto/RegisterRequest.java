package kz.runamicon.socialnetwork.dto;

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
public class RegisterRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String login;

    private String username;

    private String password;

    private String email;
}
