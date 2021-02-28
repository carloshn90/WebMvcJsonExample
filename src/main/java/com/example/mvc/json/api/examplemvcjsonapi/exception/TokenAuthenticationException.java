package com.example.mvc.json.api.examplemvcjsonapi.exception;


import org.springframework.security.core.AuthenticationException;

public class TokenAuthenticationException extends AuthenticationException {

    public TokenAuthenticationException(String message) {
        super(message);
    }
}
