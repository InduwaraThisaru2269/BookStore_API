package org.Thisaru.Models;

import java.util.Map;

public class Order {
    private int orderId;
    private int customerId;
    private Map<Integer, Integer> orderedItems;
    private double totalPrice;

    public Order(int orderId, int customerId, Map<Integer, Integer> orderedItems, double totalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderedItems = orderedItems;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
