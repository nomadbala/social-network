package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRegistrationService userRegistrationService;
    private final AuthenticationService authenticationService;

    public UserService(UserRegistrationService userRegistrationService, AuthenticationService authenticationService) {
        this.userRegistrationService = userRegistrationService;
        this.authenticationService = authenticationService;
    }

    public void register(RegisterRequest request) {
        userRegistrationService.register(request);
    }

    public String login(LoginRequest request) {
        return authenticationService.login(request);
    }
}
