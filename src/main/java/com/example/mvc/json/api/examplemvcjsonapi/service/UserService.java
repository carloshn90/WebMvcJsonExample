package com.example.mvc.json.api.examplemvcjsonapi.service;

import com.example.mvc.json.api.examplemvcjsonapi.payload.UserPayload;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserPayload> getUserList();

    Optional<UserPayload> saveUser(UserPayload userPayload);

    Optional<UserPayload> deleteUser(Long userId);

    Optional<UserPayload> updateUser(Long userId, UserPayload userPayload);
}
