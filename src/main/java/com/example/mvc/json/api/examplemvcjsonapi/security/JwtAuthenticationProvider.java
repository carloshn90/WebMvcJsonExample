package com.example.mvc.json.api.examplemvcjsonapi.security;

import com.example.mvc.json.api.examplemvcjsonapi.exception.TokenAuthenticationException;
import com.example.mvc.json.api.examplemvcjsonapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtService jwtService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.debug(authentication.toString());
        log.debug("Credentials: " + authentication.getCredentials());

        if (authentication.getCredentials() == null) {
            throw new TokenAuthenticationException("Failed to verify token");
        }

        return jwtService.verifyJwt((JwtAuthToken) authentication);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthToken.class.equals(aClass);
    }
}
