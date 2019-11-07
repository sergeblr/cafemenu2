/**package com.cafemenu.service;

import com.cafemenu.repository.ItemRepository;
import com.cafemenu.entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest(classes = {ItemRepository.class, ItemServiceImpl.class})
@ContextConfiguration(locations = {"classpath:test-service.xml"})
public class ItemServiceImplMockTest {

    @Mock
    private ItemRepository mockItemRepository;

    private ItemServiceImpl itemServiceImplUnderTest;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        itemServiceImplUnderTest = new ItemServiceImpl(mockItemRepository);
    }

    @Test
    public void testAddSingle() {
        final Item item = createItem(2);
        when(mockItemRepository.save(any(Item.class))).thenReturn(item);
        
        itemServiceImplUnderTest.add(item);

        verify(mockItemRepository).save(item);
    }

    @Test
    public void testUpdate() {
        final Item item = createItem(5);
        item.setItemName("Another");
        
        itemServiceImplUnderTest.update(item);

        verify(mockItemRepository).save(item);
    }

    @Test
    public void testDelete() {
        final Integer itemId = 0;

        itemServiceImplUnderTest.delete(itemId);

        verify(mockItemRepository).deleteById(itemId);
    }

    @Test
    public void testFindAll() {
        final List<Item> expectedResult = Arrays.asList();
        //when(mockItemRepository.findAll()).thenReturn(Arrays.asList());

        final List<Item> result = itemServiceImplUnderTest.findAll();
        
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindItemById() {
        final Integer itemId = 0;
        final Item expectedResult = new Item();
        expectedResult.setItemName("MockItemName");
        when(mockItemRepository.findById(itemId)).thenReturn(Optional.of(expectedResult));
        
        final Item result = itemServiceImplUnderTest.findItemById(itemId);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindItemByName() {
        final String itemName = "Nuggets";
        final Item expectedResult = new Item();
        expectedResult.setItemName("Nuggets");
        when(mockItemRepository.findByItemName("Nuggets")).thenReturn(Optional.of(expectedResult));

        final Item result = itemServiceImplUnderTest.findItemByName(itemName);

        assertEquals(expectedResult, result);
    }

    private static Item createItem(Integer itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName("Item"+itemId);
        item.setItemPrice(new BigDecimal(itemId+0.5));
        return item;
    }
    
}**/
