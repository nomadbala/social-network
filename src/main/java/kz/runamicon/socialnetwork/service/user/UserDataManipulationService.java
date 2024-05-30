package kz.runamicon.socialnetwork.service.user;

import kz.runamicon.socialnetwork.dto.security.JwtAuthenticationToken;
import kz.runamicon.socialnetwork.dto.user.UpdateEmailRequest;
import kz.runamicon.socialnetwork.dto.user.UpdateLoginRequest;
import kz.runamicon.socialnetwork.dto.user.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.dto.user.UserDto;
import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.exception.UserNotFoundException;
import kz.runamicon.socialnetwork.mapper.UserMapper;
import kz.runamicon.socialnetwork.repository.RoleRepository;
import kz.runamicon.socialnetwork.repository.UserRepository;
import kz.runamicon.socialnetwork.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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


    @Cacheable(value = "UserDataManipulationService::findById", key = "#id")
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));

        return UserMapper.INSTANCE.userToUserDto(user);
    }

   // @Cacheable(value = "UserDataManipulationService::findByLogin", key = "#login")
   // public UserDto findByLogin(String login) {
   //     User user = userRepository.findByLogin(login).orElseThrow(() -> new UserNotFoundException("User with login " + login + " not found."));
   //     return UserMapper.INSTANCE.userToUserDto(user);
   // }
   // @Cacheable(value = "UserDataManipulationService::findByEmail", key = "#email")
   // public UserDto findByEmail(String email) {
   //     User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
   //     return UserMapper.INSTANCE.userToUserDto(user);
   // }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.usersToUserDtos(users);
    }

    @Transactional
    @Modifying
    @Caching(put={
            @CachePut(value = "UserDataManipulationService::findById", key = "#request.id()")
    })
    public void updateUsername(UpdateUsernameRequest request) {
        int updates = userRepository.updateUsername(request.id(), request.username());
        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
    }

    @Transactional
    @Modifying
    @Caching(put={
            @CachePut(value = "UserDataManipulationService::findById", key = "#request.id()")
    })
    public void updateEmail(UpdateEmailRequest request) {
        int updates = userRepository.updateEmail(request.id(), request.newEmail());

        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
    }

    @Transactional
    @Modifying
    @Caching(put={
            @CachePut(value = "UserDataManipulationService::findById", key = "#request.id()")
    })
    public JwtAuthenticationToken updateLogin(UpdateLoginRequest request) {
        int updates = userRepository.updateLogin(request.id(), request.newLogin());
        if (updates == 0) {
            throw new UserNotFoundException("User with id " + request.id() + " not found.");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.newLogin());
        return jwtUtil.generateToken(userDetails);
    }

}
