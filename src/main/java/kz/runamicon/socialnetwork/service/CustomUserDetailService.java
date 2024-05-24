package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.entity.User;
import kz.runamicon.socialnetwork.exception.UserNotFoundException;
import kz.runamicon.socialnetwork.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    @NonNull
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByLogin(username).orElseThrow(() -> new UserNotFoundException(username));

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities);
    }

    public UserDetails loadUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities);
    }
}
