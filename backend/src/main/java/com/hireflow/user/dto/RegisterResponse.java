package com.hireflow.user.dto;

import java.util.UUID;

import com.hireflow.user.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Purpose:
 * Represents the response returned after a successful user registration.
 *
 * Responsibilities:
 * - Return basic user information.
 * - Confirm successful registration.
 *
 * Never contains:
 * - Password
 * - Internal security details
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterResponse {

    private UUID id;

    private String username;

    private String email;

    private Role role;

    private String message;

}