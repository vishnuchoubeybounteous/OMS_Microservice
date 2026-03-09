package com.vishnu.auth_service.service;

import com.vishnu.auth_service.dto.AuthRequest;
import com.vishnu.auth_service.dto.AuthResponse;
import com.vishnu.auth_service.dto.RegisterRequest;
import com.vishnu.auth_service.dto.ValidateTokenResponse;
import com.vishnu.auth_service.entity.Role;
import com.vishnu.auth_service.entity.User;
import com.vishnu.auth_service.repository.RoleRepository;
import com.vishnu.auth_service.repository.UserRepository;
import com.vishnu.auth_service.security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       AuthenticationManager authenticationManager,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(role);

        userRepository.save(user);
        return "User registered successfully";
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .toList();

        String token = jwtService.generateToken(user.getUsername(), roles);
        return new AuthResponse(token);
    }

    public ValidateTokenResponse validate(String token) {
        boolean valid = jwtService.isTokenValid(token);
        if (!valid) {
            return new ValidateTokenResponse(null, List.of(), false);
        }
        return new ValidateTokenResponse(
                jwtService.extractUsername(token),
                jwtService.extractRoles(token),
                true
        );
    }
}

