package com.owurakuzenas.invoice_app.service.implementation;

import com.owurakuzenas.invoice_app.entity.Item;
import com.owurakuzenas.invoice_app.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

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
}