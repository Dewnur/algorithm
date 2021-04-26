package com.kosobanov.components;

import com.kosobanov.Type;

public class Hard {
    public String model;
    public int memory;
    public Type type;
    public int price;

    public Hard(String model, int memory, int price) {
        this.model = model;
        this.memory = memory;
        this.price = price;
    }

    public String toString() {
        return String.format("{Type: Hard, model: %s , memory: %s, price: %s}", model, memory, price);
    }

}
