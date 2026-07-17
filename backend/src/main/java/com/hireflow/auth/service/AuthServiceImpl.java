package com.hireflow.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hireflow.auth.exception.EmailAlreadyExistsException;
import com.hireflow.auth.exception.UsernameAlreadyExistsException;
import com.hireflow.user.dto.RegisterRequest;
import com.hireflow.user.dto.RegisterResponse;
import com.hireflow.user.entity.User;
import com.hireflow.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {

            throw new UsernameAlreadyExistsException(
                    "Username '" + request.getUsername() + "' is already taken.");

        }

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new EmailAlreadyExistsException(
                    "Email '" + request.getEmail() + "' is already registered.");

        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);

        // Response

        RegisterResponse response = new RegisterResponse();

        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());
        response.setMessage("User registered successfully.");

        return response;

    }

}
