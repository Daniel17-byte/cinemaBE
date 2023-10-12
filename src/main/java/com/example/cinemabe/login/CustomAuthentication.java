package com.example.cinemabe.login;
import com.example.cinemabe.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
public class CustomAuthentication implements Authentication {
    private final User user;
    private final String message;
    private boolean authenticated = true;

    public CustomAuthentication(User user, String message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return the list of authorities for the authenticated user
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return user.getFirstName();
    }
}

