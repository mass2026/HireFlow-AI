package com.hireflow.auth.service;

import org.springframework.stereotype.Service;

import com.hireflow.user.dto.RegisterRequest;
import com.hireflow.user.dto.RegisterResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public RegisterResponse register(RegisterRequest request) {
       
        return null;
    }

}
