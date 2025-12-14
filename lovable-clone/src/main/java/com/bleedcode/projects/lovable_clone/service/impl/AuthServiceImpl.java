package com.bleedcode.projects.lovable_clone.service.impl;

import org.apache.catalina.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import com.bleedcode.projects.lovable_clone.dto.auth.AuthResponse;
import com.bleedcode.projects.lovable_clone.dto.auth.SignupRequest;
import com.bleedcode.projects.lovable_clone.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)    
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    public AuthResponse signup(SignupRequest request) {
        // Implement login logic here
        userRepository.findByUsername(request.username()).ifPresent(() -> {
            throw new BadRequestException("Username is already taken" + request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        return new AuthResponse("dummy-token", userMapper.toProfileResponse(user)
    able_clone.dto.auth.LoginRequest request) {
        // Implement login logic here
        return null;
    }

}
