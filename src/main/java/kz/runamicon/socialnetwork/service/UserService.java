package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.dto.UpdateUsernameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRegistrationService userRegistrationService;

    private final AuthenticationService authenticationService;

    private final UserDataManipulationService userDataManipulationService;

    public void register(RegisterRequest request) {
        userRegistrationService.register(request);
    }

    public String login(LoginRequest request) {
        return authenticationService.login(request);
    }

    public String updateUsername(UpdateUsernameRequest request) {
        return userDataManipulationService.updateUsername(request);
    }
}
