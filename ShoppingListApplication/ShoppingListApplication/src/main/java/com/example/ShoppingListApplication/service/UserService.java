package com.example.ShoppingListApplication.service;

import com.example.ShoppingListApplication.model.User;
import com.example.ShoppingListApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUserList(){
        return userRepository.findAll();
    }
}
