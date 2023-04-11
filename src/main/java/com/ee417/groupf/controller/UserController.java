package com.ee417.groupf.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ee417.groupf.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.ee417.groupf.model.UserModel;

@RestController
@RequestMapping("")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

//    public ResponseEntity<List<UserModel>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> postUser(@RequestBody UserModel userModel) {
        return ResponseEntity.created(URI.create("user/created")).body(userService.postUser(userModel));
    }
}
