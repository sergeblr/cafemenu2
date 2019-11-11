package com.cafemenu.service;

import com.cafemenu.repository.ItemRepository;
import com.cafemenu.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void add(Item item) {
        LOGGER.debug("ItemServiceImpl: add({})", item);
        itemRepository.save(item);
    }

    @Override
    public void update(Item item) {
        LOGGER.debug("ItemServiceImpl: update({})", item);
        itemRepository.save(item);
    }

    @Override
    public void delete(Integer itemId) {
        LOGGER.debug("ItemServiceImpl: delete({})", itemId);
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> findAll() {
        LOGGER.debug("ItemServiceImpl: findAll()");
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Item findItemById(Integer itemId) {
        LOGGER.debug("ItemServiceImpl: findItemById({})", itemId);
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Failed to get items from DB"));
    }

    @Override
    public Item findItemByName(String itemName) {
        LOGGER.debug("ItemServiceImpl: findItemByName({})", itemName);
        return itemRepository.findByItemName(itemName)
                .orElse(null);
    }
}
