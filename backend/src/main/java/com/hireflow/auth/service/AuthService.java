package com.hireflow.auth.service;

import com.hireflow.user.dto.RegisterRequest;
import com.hireflow.user.dto.RegisterResponse;


/**
 * Purpose:
 * Defines authentication-related business operations.
 *
 * Responsibilities:
 * - User registration.
 * - User login. (Future)
 * - Password reset. (Future)
 * - Email verification. (Future)
 */
public interface AuthService {
  
    RegisterResponse register(RegisterRequest request);
}
