package kz.runamicon.socialnetwork.service;

import jakarta.transaction.Transactional;
import kz.runamicon.socialnetwork.dto.JwtAuthenticationToken;
import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.exception.AuthenticationFailedException;
import kz.runamicon.socialnetwork.util.JwtUtil;
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
    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    @Transactional
    public JwtAuthenticationToken login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.login(), request.password()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.login());
            return jwtUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException(e.getMessage(), e);
        }
    }
}
