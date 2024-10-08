package com.example.ShoppingListApplication.service;

import com.example.ShoppingListApplication.model.ShoppingList;
import com.example.ShoppingListApplication.model.User;
import com.example.ShoppingListApplication.repository.ShoppingListRepository;
import com.example.ShoppingListApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingList createShoppingList(ShoppingList shoppingList, Long userId){
        System.out.println("fetching user with id:" +userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("user Found:" + user.getUsername());
        shoppingList.setUser(user);
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList findById(Long id)
    {
        return shoppingListRepository.findById(id).orElseThrow(() -> new RuntimeException("Shopping List not found"));
    }
    public void deleteShoppingList(Long id){
        shoppingListRepository.deleteById(id);
    }

    public List<ShoppingList> getAllShoppingList(){
        return shoppingListRepository.findAll();
    }
}
