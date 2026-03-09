package com.vishnu.auth_service.controller;
import com.vishnu.auth_service.dto.AuthRequest;
import com.vishnu.auth_service.dto.AuthResponse;
import com.vishnu.auth_service.dto.RegisterRequest;
import com.vishnu.auth_service.dto.ValidateTokenResponse;
import com.vishnu.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<ValidateTokenResponse> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok(authService.validate(token));
    }
}

