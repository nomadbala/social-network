package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.dto.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateUsername(UpdateUsernameRequest request) {
        userDataManipulationService.updateUsername(request);
    }

    public List<UserDto> findAll() {
        return userDataManipulationService.findAll();
    }
}
