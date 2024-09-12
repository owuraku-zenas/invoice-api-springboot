package com.owurakuzenas.invoice_app.service.implementation;

import com.owurakuzenas.invoice_app.entity.Item;
import com.owurakuzenas.invoice_app.repository.ItemRepository;
import com.owurakuzenas.invoice_app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItem(int id) {
        return null;
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
    public Item updateItem(Item item) {
        return null;
    }
}
