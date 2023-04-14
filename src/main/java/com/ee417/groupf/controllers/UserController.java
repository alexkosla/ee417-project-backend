package com.ee417.groupf.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ee417.groupf.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.ee417.groupf.models.UserModel;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

<<<<<<< Updated upstream:src/main/java/com/ee417/groupf/controllers/UserController.java
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
=======
    @GetMapping("/getUsers")
   public ResponseEntity<List<UserModel>> getAllUsers() {
        System.out.println("--- Get Users ---");
       return ResponseEntity.ok(userService.getAllUsers());
   }
>>>>>>> Stashed changes:src/main/java/com/ee417/groupf/controller/UserController.java

    @PostMapping("/postUser")
    public ResponseEntity<UserModel> postUser(@RequestBody UserModel userModel) {
        return ResponseEntity.created(URI.create("user/created")).body(userService.postUser(userModel));
    }
}
