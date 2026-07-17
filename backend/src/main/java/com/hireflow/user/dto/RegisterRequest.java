package com.hireflow.user.dto;

import java.util.UUID;

import com.hireflow.user.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the data required to register a new user.
 */

@NoArgsConstructor
@Getter
@Setter

public class RegisterRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private  String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20)
    private String password;
     @NotNull(message = "Role is required")
    private Role role;


}
