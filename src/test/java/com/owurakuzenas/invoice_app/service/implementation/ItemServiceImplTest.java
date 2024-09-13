package com.owurakuzenas.invoice_app.service.implementation;

import com.owurakuzenas.invoice_app.entity.Item;
import com.owurakuzenas.invoice_app.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canCreateItem() {
        Item item = new Item();

        item.setName("Boulder");
        item.setDescription("Boulder");
        item.setUnitPrice(20.5);
        item.setQuantity(10);
        item.setTotalPrice(205.0);


        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> {
                    Item savedItem = invocation.getArgument(0);
                    savedItem.setId(1L);
                    return savedItem;
                }
        );


        Item savedItem = itemService.saveItem(item);
        assertNotNull(savedItem);
        assertNotNull(savedItem.getId());
        assertEquals("Boulder", savedItem.getName());
        assertEquals("Boulder", savedItem.getDescription());
        assertEquals(20.5, savedItem.getUnitPrice());
        assertEquals(10, savedItem.getQuantity());
        assertEquals(205.0, savedItem.getTotalPrice());

        verify(itemRepository, times(1)).save(any(Item.class));
    }

    @Test
    void caGetItemById() {
        int itemId = 1;

        Item item = new Item();
        item.setId((long) itemId);
        item.setName("Boulder");
        item.setDescription("Boulder");
        item.setUnitPrice(20.5);
        item.setQuantity(10);
        item.setTotalPrice(205.0);

        when(itemRepository.findById((long) itemId)).thenReturn(Optional.of(item));

        Item foundItem = itemService.getItem(itemId);

        assertDoesNotThrow(() -> new RuntimeException());
        assertNotNull(foundItem);
        assertEquals("Boulder", foundItem.getName());
        assertEquals("Boulder", foundItem.getDescription());
        assertEquals(20.5, foundItem.getUnitPrice());
        assertEquals(10, foundItem.getQuantity());
        assertEquals(205.0, foundItem.getTotalPrice());

        verify(itemRepository, times(1)).findById((long) itemId);
    }

    @Test
    void canUpdateItem() {
        Item item = new Item();
        item.setName("Boulder");
        item.setDescription("Boulder");
        item.setUnitPrice(20.5);
        item.setQuantity(10);
        item.setTotalPrice(205.0);


        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> {
                    Item savedItem = invocation.getArgument(0);
                    savedItem.setId(1L);
                    return savedItem;
                }
        );

        Item savedItem = itemService.saveItem(item);

        Item itemUpdate = new Item();
        itemUpdate.setName(savedItem.getName());
        itemUpdate.setDescription("Changed description");
        itemUpdate.setUnitPrice(100.0);
        itemUpdate.setQuantity(10);
        itemUpdate.setTotalPrice(1000.0);


        when(itemRepository.findById(savedItem.getId())).thenReturn(Optional.of(savedItem));
        when(itemRepository.save(any(Item.class))).thenReturn(itemUpdate);

        Item updatedItem = itemService.updateItem(itemUpdate, Math.toIntExact(savedItem.getId()));

        assertDoesNotThrow(() -> new RuntimeException());
        assertNotNull(updatedItem);
        assertEquals("Boulder", updatedItem.getName());
        assertEquals("Changed description", updatedItem.getDescription());
        assertEquals(100.0, updatedItem.getUnitPrice());
        assertEquals(10, updatedItem.getQuantity());
        assertEquals(1000.0, updatedItem.getTotalPrice());

        verify(itemRepository, times(2)).save(any(Item.class));

    }
}