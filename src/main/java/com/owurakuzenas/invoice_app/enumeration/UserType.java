package com.owurakuzenas.invoice_app.enumeration;

import lombok.Getter;

@Getter
public enum UserType {
    CUSTOMER("customer"),
    VENDOR("vendor");

    // Method to retrieve the string value
    private final String value;

    // Constructor
    UserType(String value) {
        this.value = value;
    }

}
