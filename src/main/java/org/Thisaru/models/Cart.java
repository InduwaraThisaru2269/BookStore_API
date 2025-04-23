package org.Thisaru.models;

import java.util.Map;

public class Cart {
    private int id;
    private int customerId;
    private Map<Integer, Integer> items; // (BookId, NoOfItems)
    private boolean isOrdered;
    public Cart(int id, int customerId, Map<Integer, Integer> items, boolean isOrdered) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.isOrdered = isOrdered;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}
