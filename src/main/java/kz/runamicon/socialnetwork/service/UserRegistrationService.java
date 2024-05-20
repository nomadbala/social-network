package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.entity.Role;
import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.repository.RoleRepository;
import kz.runamicon.socialnetwork.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final RoleRepository roleRepository;

    @NonNull
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {
        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            role = new Role("ROLE_USER");
            roleRepository.save(role);
        }

        User user = new User();
        user.setLogin(request.getLogin());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }
}
