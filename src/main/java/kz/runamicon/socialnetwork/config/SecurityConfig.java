package kz.runamicon.socialnetwork.config;

import jakarta.servlet.http.HttpServletResponse;
import kz.runamicon.socialnetwork.exception.AuthenticationManagerFailedException;
import kz.runamicon.socialnetwork.exception.SecurityFilterChainInitializationException;
import kz.runamicon.socialnetwork.service.CustomUserDetailService;
import kz.runamicon.socialnetwork.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] URLS_NO_AUTHORIZE_PERMIT = {
            "api/auth/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**"
    };

    private static final List<String> CORS_ALLOWED_ORIGINS = List.of(
            "http://localhost:5173"
    );

    private static final List<String> CORS_ALLOWED_METHODS = List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
    );

    private static final List<String> CORS_ALLOWED_HEADERS = List.of(
            "content-type", "authorization"
    );

    private final CustomUserDetailService userDetailService;

    private final JwtService jwtService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                    .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                            authorizationManagerRequestMatcherRegistry
                                    .requestMatchers(URLS_NO_AUTHORIZE_PERMIT).permitAll()
                                    .anyRequest().authenticated()
                    )
                    .exceptionHandling(httpSecurityExceptionHandlingConfigurer ->
                            httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint((request, response, authenticationException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                    )
                    .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authenticationProvider())
                    .addFilterBefore(jwtService, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        } catch (Exception e) {
            throw new SecurityFilterChainInitializationException(e.getMessage(), e);
        }
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(CORS_ALLOWED_ORIGINS);
        configuration.setAllowedMethods(CORS_ALLOWED_METHODS);
        configuration.setAllowedHeaders(CORS_ALLOWED_HEADERS);
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
        try {
            return authenticationConfiguration.getAuthenticationManager();
        } catch (Exception e) {
            throw new AuthenticationManagerFailedException(e.getMessage());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
