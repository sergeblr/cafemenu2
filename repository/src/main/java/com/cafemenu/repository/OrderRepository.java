package com.cafemenu.repository;

import com.cafemenu.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Implemented: findById(id), findAll, deleteById(id), save(Item)

    // Additive to basic CRUD:
    Optional<Order> findOrderByOrderId(String itemName);

    //TODO: List<>

}
