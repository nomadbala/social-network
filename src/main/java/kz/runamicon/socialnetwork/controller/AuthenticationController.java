package kz.runamicon.socialnetwork.controller;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {
    @NonNull
    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);
        userService.register(registerRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest loginRequest) {
        log.info("Login request: {}", loginRequest);
        return userService.login(loginRequest);
    }
}
