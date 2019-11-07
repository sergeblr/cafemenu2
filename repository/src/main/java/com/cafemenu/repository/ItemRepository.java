package com.cafemenu.repository;

import com.cafemenu.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// @RepositoryRestResource      // Give DIRECT acces to repository via REST access (no need to implement REST layer anymore)
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    // Implemented: findById(id), findAll, deleteById(id), save(Item)

    // Additive to basic CRUD:
    Optional<Item> findByItemName(String itemName);

}
