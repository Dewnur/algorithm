package com.kosobanov.components;

public class Housing {
    public String model;
    public int price;

    public Housing(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String toString() {
        return String.format("{Type: Housing, model: %s, price: %s}", model, price);
    }
}
