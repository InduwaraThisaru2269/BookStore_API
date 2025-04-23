package org.Thisaru.models;

import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<CartItem> orderedItems;
    private double totalPrice;

    public Order() {}
    public Order(int id, int customerId, List<CartItem> orderedItems, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.orderedItems = orderedItems;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<CartItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<CartItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
