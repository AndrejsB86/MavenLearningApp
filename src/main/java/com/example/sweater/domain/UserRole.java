package com.example.sweater.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
