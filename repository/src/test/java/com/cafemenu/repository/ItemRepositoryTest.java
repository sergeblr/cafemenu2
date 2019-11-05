package com.cafemenu.repository;

import com.cafemenu.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
@DataJpaTest
@TestPropertySource("classpath:test.properties")        // Use test.properties in test dir, if commented -> use main application.properties
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {

    private static final String WRAP = "Wrap";
    private static final BigDecimal PRICE = new BigDecimal("5.0");

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findAll() {
        List<Item> items = itemRepository.findAll();
        assertNotNull(items);
        assertTrue(items.size() > 0);

        //
        items.forEach(item -> System.out.println(" #"+item.getItemId()+"="+item.getItemName()));
    }
/**
    @Test
    public void findItemById() {
        Item testItem = itemRepository.findById(1).get();
        assertNotNull(testItem);
        assertTrue(testItem.getItemId().equals(1));
        assertEquals("Burger",testItem.getItemName());
    }

    @Test
    public void findItemByName() {
        Item testItem = itemRepository.findByItemName("Nuggets").get();
        assertNotNull(testItem);
        assertTrue(testItem.getItemName().equals("Nuggets"));
        assertEquals("Nuggets",testItem.getItemName());
    }

    @Test
    public void add() {
        Item testItem = new Item();
        testItem.setItemName(WRAP);
        testItem.setItemPrice(PRICE);
        Item newItem = itemRepository.save(testItem);
        assertNotNull(newItem.getItemId());
        assertEquals(WRAP,newItem.getItemName());
        assertEquals(PRICE,newItem.getItemPrice());
    }

    @Test
    public void update() {
        Item testItem = new Item();
        testItem.setItemName(WRAP);
        testItem.setItemPrice(PRICE);
        testItem = itemRepository.save(testItem);
        testItem.setItemName("Frie");
        testItem.setItemPrice(new BigDecimal("6.5"));
        itemRepository.save(testItem);
        Item updatedItem = itemRepository.findById(testItem.getItemId()).get();
        assertTrue(testItem.getItemId().equals(updatedItem.getItemId()));
        assertTrue(testItem.getItemName().equals(updatedItem.getItemName()));
        assertTrue(testItem.getItemPrice().equals(updatedItem.getItemPrice()));
    }

    @Test
    public void delete() {
        Item testItem = new Item();
        testItem.setItemName(WRAP);
        testItem.setItemPrice(PRICE);
        testItem = itemRepository.save(testItem);
        List<Item> items = itemRepository.findAll();
        int sizeBefore = items.size();
        itemRepository.deleteById(testItem.getItemId());
        assertTrue((sizeBefore - 1) == itemRepository.findAll().size());
    }
**/
}