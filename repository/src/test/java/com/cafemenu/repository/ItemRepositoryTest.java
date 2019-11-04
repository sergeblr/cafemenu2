package com.cafemenu.repository;

import com.cafemenu.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@DataJpaTest
@TestPropertySource("classpath:test.properties")
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
**/
}