package com.example.ShoppingListApplication.repository;

import com.example.ShoppingListApplication.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    List<ShoppingList> findAll();
}
