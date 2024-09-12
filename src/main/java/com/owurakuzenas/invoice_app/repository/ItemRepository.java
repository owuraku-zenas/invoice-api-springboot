package com.owurakuzenas.invoice_app.repository;

import com.owurakuzenas.invoice_app.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
