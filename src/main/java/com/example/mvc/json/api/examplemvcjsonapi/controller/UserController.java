package com.example.mvc.json.api.examplemvcjsonapi.controller;

import com.example.mvc.json.api.examplemvcjsonapi.payload.UserPayload;
import com.example.mvc.json.api.examplemvcjsonapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserPayload> getUserList() {

        return this.userService.getUserList();
    }

    @PostMapping
    public ResponseEntity<UserPayload> saveUser(@RequestBody UserPayload userPayload) {

        return this.userService.saveUser(userPayload)
                .map(userPayloadSaved -> ResponseEntity.status(HttpStatus.CREATED).body(userPayloadSaved))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @DeleteMapping
    public ResponseEntity<UserPayload> deleteUser(@RequestParam Long userId) {

        return this.userService.deleteUser(userId)
                .map(userPayloadDeleted -> ResponseEntity.status(HttpStatus.OK).body(userPayloadDeleted))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping
    public ResponseEntity<UserPayload> updateUser(@RequestParam Long userId, @RequestBody UserPayload userPayload) {

        return this.userService.updateUser(userId, userPayload)
                .map(userPayloadUpdated -> ResponseEntity.status(HttpStatus.OK).body(userPayloadUpdated))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
