package kz.runamicon.socialnetwork.service;

import jakarta.transaction.Transactional;
import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.exception.AuthenticationFailedException;
import kz.runamicon.socialnetwork.util.JwtUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @NonNull
    private final JwtUtil jwtUtil;

    @NonNull
    private final UserDetailsService userDetailsService;

    @NonNull
    private final AuthenticationManager authenticationManager;

    @Transactional
    public String login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.login(), request.password()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.login());
            return jwtUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("%s\n%s".formatted(e.getMessage(), request));
        }
    }
}
