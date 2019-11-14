package com.cafemenu.repository;

import com.cafemenu.entity.ItemInOrder;
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
public class ItemInOrderRepositoryTest {

    private static final Integer IIO_ORDER_ID = 1;
    private static final Integer IIO_ITEM_ID = 2;
    private static final String IIO_ITEM_NAME = "Wrap";
    private static final BigDecimal IIO_ITEM_PRICE = new BigDecimal("3.0");
    private static final Integer IIO_ITEM_COUNT = 1;

    @Autowired
    ItemInOrderRepository itemInOrderRepository;

    @Test
    public void add() {
        ItemInOrder testIio = new ItemInOrder();
        testIio.setIioOrderId(IIO_ORDER_ID);
        testIio.setIioItemId(IIO_ITEM_ID);
        testIio.setIioItemName(IIO_ITEM_NAME);
        testIio.setIioItemPrice(IIO_ITEM_PRICE);
        testIio.setIioItemCount(IIO_ITEM_COUNT);
        ItemInOrder newIio = itemInOrderRepository.save(testIio);
        assertEquals(IIO_ORDER_ID,newIio.getIioOrderId());
        assertEquals(IIO_ITEM_ID,newIio.getIioItemId());
        assertEquals(IIO_ITEM_NAME,newIio.getIioItemName());
        assertEquals(IIO_ITEM_PRICE,newIio.getIioItemPrice());
        assertEquals(IIO_ITEM_COUNT,newIio.getIioItemCount());
    }

    @Test
    public void update() {
        ItemInOrder testIio = new ItemInOrder();
        testIio.setIioOrderId(IIO_ORDER_ID);
        testIio.setIioItemId(IIO_ITEM_ID);
        testIio.setIioItemName(IIO_ITEM_NAME);
        testIio.setIioItemPrice(IIO_ITEM_PRICE);
        testIio.setIioItemCount(IIO_ITEM_COUNT);
        testIio = itemInOrderRepository.save(testIio);
        testIio.setIioOrderId(new Integer(2));
        testIio.setIioItemId(new Integer(3));
        testIio.setIioItemName("AnotherWrap");
        testIio.setIioItemPrice(new BigDecimal("4.0"));
        testIio.setIioItemCount(new Integer(2));
        itemInOrderRepository.save(testIio);
        ItemInOrder updatedIio = itemInOrderRepository.findItemInOrderByIioOrderIdAndIioItemId(2, 3).get();
        assertTrue(testIio.getIioOrderId().equals(updatedIio.getIioOrderId()));
        assertTrue(testIio.getIioItemId().equals(updatedIio.getIioItemId()));
        assertTrue(testIio.getIioItemName().equals(updatedIio.getIioItemName()));
        assertTrue(testIio.getIioItemPrice().equals(updatedIio.getIioItemPrice()));
        assertTrue(testIio.getIioItemCount().equals(updatedIio.getIioItemCount()));
    }

    @Test
    public void delete() {
        ItemInOrder testIio = new ItemInOrder();
        testIio.setIioOrderId(IIO_ORDER_ID);
        testIio.setIioItemId(IIO_ITEM_ID);
        testIio.setIioItemName(IIO_ITEM_NAME);
        testIio.setIioItemPrice(IIO_ITEM_PRICE);
        testIio.setIioItemCount(IIO_ITEM_COUNT);
        testIio = itemInOrderRepository.save(testIio);
        List<ItemInOrder> iio = itemInOrderRepository.findAll();
        int sizeBefore = iio.size();
        itemInOrderRepository.deleteItemInOrderByIioOrderIdAndIioItemId(testIio.getIioOrderId(), testIio.getIioItemId());
        assertTrue((sizeBefore - 1) == itemInOrderRepository.findAll().size());
    }

    @Test
    public void findAll() {
        List<ItemInOrder> iio = itemInOrderRepository.findAll();
        assertNotNull(iio);
        assertTrue(iio.size() > 0);
    }

    @Test
    public void findIioByOrderId() {
        ItemInOrder testIio = new ItemInOrder();
        testIio.setIioOrderId(IIO_ORDER_ID);
        testIio.setIioItemId(IIO_ITEM_ID);
        testIio.setIioItemName(IIO_ITEM_NAME);
        testIio.setIioItemPrice(IIO_ITEM_PRICE);
        testIio.setIioItemCount(IIO_ITEM_COUNT);
        testIio = itemInOrderRepository.save(testIio);
        List<ItemInOrder> findIios = itemInOrderRepository.findItemInOrdersByIioOrderId(IIO_ORDER_ID);
        assertNotNull(findIios);
        assertTrue(findIios.size() > 0);
    }

    @Test
    public void findIioByOrderItemId() {
        ItemInOrder testIio = new ItemInOrder();
        testIio.setIioOrderId(IIO_ORDER_ID);
        testIio.setIioItemId(IIO_ITEM_ID);
        testIio.setIioItemName(IIO_ITEM_NAME);
        testIio.setIioItemPrice(IIO_ITEM_PRICE);
        testIio.setIioItemCount(IIO_ITEM_COUNT);
        itemInOrderRepository.save(testIio);
        ItemInOrder findIio = itemInOrderRepository.findItemInOrderByIioOrderIdAndIioItemId(IIO_ORDER_ID, IIO_ITEM_ID).get();
        assertNotNull(findIio);
        assertEquals(IIO_ORDER_ID, findIio.getIioOrderId());
        assertEquals(IIO_ITEM_ID, findIio.getIioItemId());
        assertEquals(IIO_ITEM_NAME, findIio.getIioItemName());
        assertEquals(IIO_ITEM_PRICE, findIio.getIioItemPrice());
        assertEquals(IIO_ITEM_COUNT, findIio.getIioItemCount());
    }
}
