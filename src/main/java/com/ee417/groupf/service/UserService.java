package com.ee417.groupf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ee417.groupf.model.UserModel;
import com.ee417.groupf.repositorys.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
    }

    // public List<UserModel> getAllUsers(int id) {
    //     return userRepository.findById(id);
    // }
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel postUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

}
