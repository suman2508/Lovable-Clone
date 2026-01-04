package com.bleedcode.projects.lovable_clone.service.impl;

import org.apache.catalina.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bleedcode.projects.lovable_clone.dto.auth.AuthResponse;
import com.bleedcode.projects.lovable_clone.dto.auth.SignupRequest;
import com.bleedcode.projects.lovable_clone.security.AuthUtil;
import com.bleedcode.projects.lovable_clone.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)    
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;


    @Override
    public AuthResponse signup(SignupRequest request) {
        // Implement login logic here
        userRepository.findByUsername(request.username()).ifPresent(() -> {
            throw new BadRequestException("Username is already taken" + request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse("dummy-token", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(String username, String password) {
        // Implement login logic here
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("Invalid username or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Invalid username or password");
        }

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

}
