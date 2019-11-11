package com.cafemenu.repository;

import com.cafemenu.entity.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


//@ExtendWith(SpringExtension.class)    // Tell JUnit5 to enable Spring support (from SpringBoot 2.1 -> already included in @DataJpaTest)
//@RunWith(SpringRunner.class)      // For JUnit4
@ContextConfiguration(classes = {TestConfig.class})
@DataJpaTest
@TestPropertySource("classpath:test.properties")        // Use test.properties in test dir, if this line is commented -> use main application.properties
@AutoConfigureTestDatabase(replace = NONE)      // NONE = @DataJpaTest will no do replacing configured datasource by in-memory datasource (without this line - it does it)
//@AutoConfigureEmbeddedDatabase
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:import-test.sql")     // Run this SQL before EACH test
@Sql(scripts = "classpath:import-test.sql")     // Run this SQL script before test
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)     // Do not add SQL data each time script runs (merge-mode)
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

    @Test
    public void findItemById() {
        Item testItem = new Item();
        testItem.setItemName(WRAP);
        testItem.setItemPrice(PRICE);
        testItem = itemRepository.save(testItem);
        Item foundItem = itemRepository.findById(testItem.getItemId()).get();
        assertNotNull(foundItem);
        assertTrue(foundItem.getItemId().equals(testItem.getItemId()));
    }

    @Test
    public void findItemByName() {
        Item testItem = new Item();
        testItem.setItemName(WRAP);
        testItem.setItemPrice(PRICE);
        testItem = itemRepository.save(testItem);
        Item foundItem = itemRepository.findByItemName(testItem.getItemName()).get();
        assertNotNull(foundItem);
        assertTrue(foundItem.getItemName().equals(testItem.getItemName()));
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

}