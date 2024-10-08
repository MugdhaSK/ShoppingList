package com.example.ShoppingListApplication.controller;

import com.example.ShoppingListApplication.model.Item;
import com.example.ShoppingListApplication.model.ShoppingList;
import com.example.ShoppingListApplication.model.User;
import com.example.ShoppingListApplication.repository.ShoppingListRepository;
import com.example.ShoppingListApplication.service.ShoppingListService;
import com.example.ShoppingListApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingListController {
    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    //APi to add shopping list
    @PostMapping("/shopping-lists")
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody ShoppingList shoppingList, @RequestParam Long userId){
        System.out.println("Process is in Post Mapping");
        ShoppingList createdShoppingList = shoppingListService.createShoppingList(shoppingList, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShoppingList);
    }

    // Add items to a shopping list using shoppingListId as path variable
    @PostMapping("/shopping-lists/{shoppingListId}/items")
    public ResponseEntity<Item> addItemToShoppingList(@PathVariable Long shoppingListId, @RequestBody Item item) {
        ShoppingList shoppingList = shoppingListRepository.findById(shoppingListId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ShoppingList not found with id " + shoppingListId));
        for (Item existingItem : shoppingList.getItem()) {
            if (existingItem.getName().equalsIgnoreCase(item.getName())) {
                return ResponseEntity.status(HttpStatus.OK).body(existingItem);
            }
        }
        item.setShoppingList(shoppingList);
        shoppingList.getItem().add(item);
        shoppingListRepository.save(shoppingList);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    //Add user
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println("Process is in Post Mapping for user");
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    //get list of all user
    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUserLists(){
        return ResponseEntity.ok(userService.getAllUserList());
    }


    // Get the complete shopping list
    @GetMapping("/shopping-list/all")
    public ResponseEntity<List<ShoppingList>> getAllShoppingLists(){
        return ResponseEntity.ok(shoppingListService.getAllShoppingList());
    }

    //Delete the shopping list
    @DeleteMapping("/{id}")
    public ResponseEntity<List<ShoppingList>> deleteShoppingList(@PathVariable Long id){
        shoppingListService.deleteShoppingList(id);
        return ResponseEntity.noContent().build();
    }
}
