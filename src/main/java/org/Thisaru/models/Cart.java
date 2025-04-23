package org.Thisaru.models;

import java.util.List;
import java.util.Map;

public class Cart {
    private int id;
    private int customerId;
    private List<CartItem> items;
    private boolean isOrdered;

    public Cart() {}
    public Cart(int id, int customerId, List<CartItem> items, boolean isOrdered) {
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

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}
