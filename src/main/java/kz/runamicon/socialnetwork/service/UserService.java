package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @NonNull
    private final UserRegistrationService userRegistrationService;

    @NonNull
    private final AuthenticationService authenticationService;

    public void register(RegisterRequest request) {
        userRegistrationService.register(request);
    }

    public String login(LoginRequest request) {
        return authenticationService.login(request);
    }
}
