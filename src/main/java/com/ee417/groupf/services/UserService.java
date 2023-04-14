package com.ee417.groupf.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ee417.groupf.models.UserModel;
import com.ee417.groupf.repositorys.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

<<<<<<< Updated upstream:src/main/java/com/ee417/groupf/services/UserService.java
    public List<UserModel> getAllUsers() {
        return userRepository.getAllUsers();
    }
=======
   public List<UserModel> getAllUsers() {
       return userRepository.getAllUsers();
   }
>>>>>>> Stashed changes:src/main/java/com/ee417/groupf/service/UserService.java

    public UserModel postUser(UserModel userModel) {
        return userRepository.postUsers(userModel);
    }
    
}
