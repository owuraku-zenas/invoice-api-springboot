package com.owurakuzenas.invoice_app.service;

import com.owurakuzenas.invoice_app.entity.Item;

import java.util.Set;

public interface ItemService {
    public Item getItem(int id);
    public Set<Item> getAllItems();
    public Item saveItem(Item item);
    public Boolean deleteItem(int id);
    public Item updateItem(Item item);
}
