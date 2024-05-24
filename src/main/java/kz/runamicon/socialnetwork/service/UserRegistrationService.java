package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.entity.Role;
import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.exception.RegistrationFailedException;
import kz.runamicon.socialnetwork.repository.RoleRepository;
import kz.runamicon.socialnetwork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(RegisterRequest request) {
        Role role = roleRepository.findByName("ROLE_USER").orElseGet(
                () -> {
                    Role newRole = new Role("ROLE_USER");
                    return roleRepository.save(newRole);
                }
        );

        User user = User
                .builder()
                .login(request.login())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .roles(Collections.singleton(role))
                .build();

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RegistrationFailedException(e.getMessage(), e);
        }
    }
}
