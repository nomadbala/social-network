package kz.runamicon.socialnetwork.service;

import kz.runamicon.socialnetwork.dto.LoginRequest;
import kz.runamicon.socialnetwork.util.JwtUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public String login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
