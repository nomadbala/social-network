package kz.runamicon.socialnetwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.runamicon.socialnetwork.dto.JwtAuthenticationToken;
import kz.runamicon.socialnetwork.dto.UpdateEmailRequest;
import kz.runamicon.socialnetwork.dto.UpdateLoginRequest;
import kz.runamicon.socialnetwork.dto.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User controller", description = "Controller responsible for manipulation with user data")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "User username update",
            description = "Allows to user update their username"
    )
    @PostMapping("/update_username")
    @ResponseStatus(HttpStatus.OK)
    public void updateUsername(
            @RequestBody
            @Parameter(description = "Update username request")
            UpdateUsernameRequest request
    ) {
        userService.updateUsername(request);
    }

    @Operation(
            summary = "User email update",
            description = "Allows user to update their email"
    )
    @PostMapping("/update_email")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmail(
            @RequestBody
            @Parameter(description = "Update email request")
            UpdateEmailRequest request
    ) {
        userService.updateEmail(request);
    }

    @Operation(
            summary = "User login update",
            description = "Allows user to update their login"
    )
    @PostMapping("/update_login")
    @ResponseStatus(HttpStatus.OK)
    public JwtAuthenticationToken updateLogin(
            @RequestBody
            @Parameter(description = "Update login request")
            UpdateLoginRequest request
    ) {
        return userService.updateLogin(request);
    }
}
