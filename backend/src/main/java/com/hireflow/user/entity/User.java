package com.hireflow.user.entity;

import java.time.Instant;

import com.hireflow.common.entity.BaseEntity;
import com.hireflow.user.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Purpose:
 * Represents a system user responsible for authentication and authorization.
 *
 * Responsibilities:
 * - Store login credentials.
 * - Store role for Role-Based Access Control (RBAC).
 * - Maintain account status.
 *
 * Does NOT store:
 * - Resume
 * - Skills
 * - Education
 * - Company information
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min=3,max=50)
    private String username;

    @Column(nullable = false, unique = true, length = 225)
    private String email;

    @Column(nullable = false,length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    private Instant lastLoginAt;

}