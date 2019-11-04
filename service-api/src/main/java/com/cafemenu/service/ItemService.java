package com.cafemenu.service;

import com.cafemenu.entity.Item;

import java.util.List;

public interface ItemService {

    /**
     * Add single item
     * @param item
     * @return
     */
    void add(Item item);

    /**
     * Update item
     * @param item
     */
    void update(Item item);

    /**
     * Delete item by id
     * @param itemId
     */
    void delete(Integer itemId);

    /**
     * List all items
     * @return
     */
    List<Item> findAll();

    /**
     * Find item by itemId
     * @param itemId
     * @return
     */
    Item findItemById(Integer itemId);

    /**
     * Find item by itemName
     * @param itemName
     * @return
     */
    Item findItemByName(String itemName);
}