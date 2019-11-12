package com.cafemenu.repository;

import com.cafemenu.entity.ItemInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemInOrderRepository extends JpaRepository<ItemInOrder, Integer> {

    // Implemented: findById(id), findAll, deleteById(id), save(Item)

    // Additive to basic CRUD:
    List<ItemInOrder> findItemInOrdersByOrder_iio   //findOrderByOrderId(String itemName);



    //TODO: List<>

}
