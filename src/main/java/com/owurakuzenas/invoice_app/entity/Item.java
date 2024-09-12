package com.owurakuzenas.invoice_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double unitPrice;
    private Integer quantity;
    private Double totalPrice;
//    @ManyToOne
//    @JoinColumn(name = "vendor_id", nullable = false)
//    private User vendor;
    @OneToMany(mappedBy = "item")
    private Set<InvoiceItem> invoiceItems;
}
