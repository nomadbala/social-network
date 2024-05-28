package kz.runamicon.socialnetwork.service.user;

import kz.runamicon.socialnetwork.dto.authentication.LoginRequest;
import kz.runamicon.socialnetwork.dto.authentication.RegisterRequest;
import kz.runamicon.socialnetwork.dto.security.JwtAuthenticationToken;
import kz.runamicon.socialnetwork.dto.user.UpdateEmailRequest;
import kz.runamicon.socialnetwork.dto.user.UpdateLoginRequest;
import kz.runamicon.socialnetwork.dto.user.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.dto.user.UserDto;
import kz.runamicon.socialnetwork.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRegistrationService userRegistrationService;

    private final AuthenticationService authenticationService;

    private final UserDataManipulationService userDataManipulationService;

    public UserDto register(RegisterRequest request) {
        return userRegistrationService.register(request);
    }

    public JwtAuthenticationToken login(LoginRequest request) {
        return authenticationService.login(request);
    }

    public void updateUsername(UpdateUsernameRequest request) {
        userDataManipulationService.updateUsername(request);
    }

    public void updateEmail(UpdateEmailRequest request) {
        userDataManipulationService.updateEmail(request);
    }

    public List<UserDto> findAll() {
        return userDataManipulationService.findAll();
    }

    public JwtAuthenticationToken updateLogin(UpdateLoginRequest request) {
        return userDataManipulationService.updateLogin(request);
    }

    public UserDto findById(Long id) {
        return userDataManipulationService.findById(id);
    }
}
