package kz.runamicon.socialnetwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.runamicon.socialnetwork.dto.security.JwtAuthenticationToken;
import kz.runamicon.socialnetwork.dto.authentication.LoginRequest;
import kz.runamicon.socialnetwork.dto.authentication.RegisterRequest;
import kz.runamicon.socialnetwork.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication Controller", description = "Controller responsible for handling user authentication processes, including registration and login")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;

    @Operation(
            summary = "User registration",
            description = "Allows a user to register in the system"
    )
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody
            @Parameter(description = "User register request")
            RegisterRequest registerRequest
    ) {
        userService.register(registerRequest);
    }

    @Operation(
            summary = "User Login",
            description = "Allows a user to login in the system"
    )
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtAuthenticationToken login(
            @RequestBody
            @Parameter(description = "User login request")
            LoginRequest loginRequest
    ) {
        return userService.login(loginRequest);
    }
}
