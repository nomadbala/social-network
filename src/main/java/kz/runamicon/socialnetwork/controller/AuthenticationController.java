package kz.runamicon.socialnetwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication Controller", description = "Controller responsible for handling user authentication processes, including registration and login")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {
    @NonNull
    private final UserService userService;

    @Operation(
            summary = "User registration",
            description = "Allows a user to register in the system"
    )
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody @Parameter(description = "User register request") RegisterRequest registerRequest
    ) {
        log.info("Register request: {}", registerRequest);
        userService.register(registerRequest);
    }

    @Operation(
            summary = "User Login",
            description = "Allows a user to login in the system"
    )
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(
            @RequestBody @Parameter(description = "User login request") LoginRequest loginRequest
    ) {
        log.info("Login request: {}", loginRequest);
        return userService.login(loginRequest);
    }
}
