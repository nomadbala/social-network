package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.*;
import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.exception.UserNotFoundException;
import kz.runamicon.socialnetwork.mapper.UserMapper;
import kz.runamicon.socialnetwork.repository.RoleRepository;
import kz.runamicon.socialnetwork.repository.UserRepository;
import kz.runamicon.socialnetwork.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Modifying
    public void updateUsername(UpdateUsernameRequest request) {
        int updates = userRepository.updateUsername(request.id(), request.username());

        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
    }

    public void updateEmail(UpdateEmailRequest request) {
        int updates = userRepository.updateEmail(request.id(), request.newEmail());

        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
    }

    public JwtAuthenticationToken updateLogin(UpdateLoginRequest request) {
        int updates = userRepository.updateLogin(request.id(), request.newLogin());

        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.newLogin());
        return jwtUtil.generateToken(userDetails);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.usersToUserDtos(users);
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));

        return UserMapper.INSTANCE.userToUserDto(user);
    }
}
