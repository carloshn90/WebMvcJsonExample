package com.example.mvc.json.api.examplemvcjsonapi.service;

import com.example.mvc.json.api.examplemvcjsonapi.payload.UserPayload;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<UserPayload> getUserList() {
        return Collections.emptyList();
    }

    @Override
    public Optional<UserPayload> saveUser(UserPayload userPayload) {
        return Optional.empty();
    }

    @Override
    public Optional<UserPayload> deleteUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserPayload> updateUser(Long userId, UserPayload userPayload) {
        return Optional.empty();
    }
}
