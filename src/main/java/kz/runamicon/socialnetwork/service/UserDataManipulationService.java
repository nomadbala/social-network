package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.dto.UserDto;
import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.exception.UserNotFoundException;
import kz.runamicon.socialnetwork.mapper.UserMapper;
import kz.runamicon.socialnetwork.repository.RoleRepository;
import kz.runamicon.socialnetwork.repository.UserRepository;
import kz.runamicon.socialnetwork.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataManipulationService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final CustomUserDetailService userDetailsService;

    private final JwtUtil jwtUtil;

    @Transactional
    public void updateUsername(UpdateUsernameRequest request) {
        int updates = userRepository.updateUsername(request.id(), request.username());

        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.usersToUserDtos(users);
    }
}
