package com.bleedcode.projects.lovable_clone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bleedcode.projects.lovable_clone.dto.auth.AuthResponse;
import com.bleedcode.projects.lovable_clone.dto.auth.LoginRequest;
import com.bleedcode.projects.lovable_clone.dto.auth.SignupRequest;
import com.bleedcode.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.bleedcode.projects.lovable_clone.service.AuthService;
import com.bleedcode.projects.lovable_clone.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")   
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L; // Placeholder for authenticated user ID
        return ResponseEntity.ok(userService.getProfile(userId));
    }
    
}
