package com.ee417.groupf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Order {
    @JsonProperty("orderId")
    private long orderId;
    @JsonProperty("items")
    private List<Item> items;
    @JsonProperty("userId")
    private long userId;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("status")
    private Status status;

    @JsonProperty("address")
    private String address;

    public Order() {

    }

    public Order(long orderId, List<Item> items, long userId, String dateTime, Status status, String address) {
        this.orderId = orderId;
        this.items = items;
        this.userId = userId;
        this.dateTime = dateTime;
        this.status = status;
        this.address = address;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public enum Status {
        IN_CART,
        ORDERED
    }

    public static class Item {
        @JsonProperty("name")

        private String name;
        @JsonProperty("quantity")
        private int quantity;
        @JsonProperty("price")
        private double price;

        public Item() {

        }
        public Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
