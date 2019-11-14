package com.cafemenu.repository;

import com.cafemenu.DTO.OrderDTO;
import com.cafemenu.entity.OrderD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.time.LocalDateTime;
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
public class OrderDRepositoryTest {

    private static final Integer EMPLOYEE_ID = 21;

    @Autowired
    OrderDRepository orderDRepository;

    @Autowired
    ItemInOrderRepository itemInOrderRepository;

    @Test
    public void add() {
        OrderD testOrderD = new OrderD();
        testOrderD.setOrderEmployeeId(EMPLOYEE_ID);
        OrderD newOrderD = orderDRepository.save(testOrderD);
        assertNotNull(newOrderD.getOrderId());
        assertEquals(new Integer(EMPLOYEE_ID),newOrderD.getOrderEmployeeId());
        assertNotNull(newOrderD.getOrderDateTime());
    }

    @Test
    public void update() {
        OrderD testOrderD = new OrderD();
        testOrderD.setOrderEmployeeId(EMPLOYEE_ID);
        testOrderD = orderDRepository.save(testOrderD);
        testOrderD.setOrderEmployeeId(22);
        orderDRepository.save(testOrderD);
        OrderD updatedOrderD = orderDRepository.findOrderDByOrderId(testOrderD.getOrderId()).get();
        assertTrue(testOrderD.getOrderId().equals(updatedOrderD.getOrderId()));
        assertTrue(testOrderD.getOrderEmployeeId().equals(updatedOrderD.getOrderEmployeeId()));
    }

    @Test
    public void delete() {
        OrderD testOrderD = new OrderD();
        testOrderD.setOrderEmployeeId(EMPLOYEE_ID);
        testOrderD = orderDRepository.save(testOrderD);
        List<OrderD> orders = orderDRepository.findAll();
        int sizeBefore = orders.size();
        orderDRepository.delete(testOrderD.getOrderId());
        assertTrue((sizeBefore - 1) == orderDRepository.findAll().size());
    }

    @Test
    public void findAll() {
        List<OrderD> orders = orderDRepository.findAll();
        assertNotNull(orders);
        assertTrue(orders.size() > 0);
    }

    @Test
    public void findOrderByOrderId() {
        Integer orderId = 1;
        OrderD testOrderD = new OrderD();
        testOrderD.setOrderEmployeeId(EMPLOYEE_ID);
        testOrderD = orderDRepository.save(testOrderD);
        OrderD findOrderD = orderDRepository.findOrderDByOrderId(orderId).get();
        assertNotNull(findOrderD);
        assertTrue(findOrderD.getOrderId().equals(orderId));
        assertEquals(EMPLOYEE_ID, findOrderD.getOrderEmployeeId());
    }

    @Test
    public void findAllDTO() {
        List<OrderDTO> orderDTOs = orderDRepository.findAllDTO();
        assertNotNull(orderDTOs);
        assertTrue(orderDTOs.size() > 0);
    }

    @Test
    public void findOrdersDTOByDateTime() {
        LocalDateTime startDate = LocalDateTime.of(2019,8,15,9,00,01);
        LocalDateTime endDate = LocalDateTime.of(2019,8,15,10,00,59);
        List orders = orderDRepository.findOrdersDTOByDateTime(startDate, endDate);
        assertNotNull(orders);
        assertTrue(orders.size() > 0);
    }

}