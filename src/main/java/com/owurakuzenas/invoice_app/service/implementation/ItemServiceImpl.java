package com.owurakuzenas.invoice_app.service.implementation;

import com.owurakuzenas.invoice_app.entity.Item;
import com.owurakuzenas.invoice_app.repository.ItemRepository;
import com.owurakuzenas.invoice_app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItem(int id) {
        return itemRepository.findById((long) id).orElseThrow(() -> new RuntimeException("No Item found"));
    }

    @Override
    public Set<Item> getAllItems() {
        return Set.of();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Boolean deleteItem(int id) {
        return null;
    }

    @Override
    public Item updateItem(Item item, int id) {
        itemRepository.findById((long) id).orElseThrow(() -> new RuntimeException("No Item found"));
        item.setId((long) id);
        return itemRepository.save(item);
    }
}
