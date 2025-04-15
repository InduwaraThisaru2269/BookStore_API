package org.Thisaru.models;

import java.util.Map;

public class Cart {
    private int customerId;
    private Map<Integer, Integer> items;

    public Cart(int customerId, Map<Integer, Integer> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }
}
