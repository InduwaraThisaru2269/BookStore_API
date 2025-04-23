package org.Thisaru.models;

import java.util.Map;

public class Order {
    private int id;
    private int customerId;
    private Map<Integer, Integer> orderedItems; // (BookId, NoOfItems)
    private double totalPrice;

    public Order(int id, int customerId, Map<Integer, Integer> orderedItems, double totalPrice) {
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

    public Map<Integer, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<Integer, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
