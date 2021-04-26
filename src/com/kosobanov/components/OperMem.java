package com.kosobanov.components;

import com.kosobanov.Type;

public class OperMem {
    public String model;
    public int memory;
    public Type type;
    public int price;
    public int moduls;
    public int freq;
    public int rank;

    public OperMem(String model, int memory, int moduls, int freq, int price) {
        this.model = model;
        this.memory = memory;
        this.price = price;
        this.freq = freq;
        this.moduls = moduls;
        this.type = getType();
        this.rank = getRank();
    }


    public int getRank(){
        return Type.getRank(type) + (freq)/100 + moduls;
    }

    public Type getType() {
        if (memory > 16)
            return Type.P;
        if (memory > 8)
            return Type.G;
        return Type.W;
    }

    public String toString() {
        return String.format("{Type: OperMem, model: %s , memory: %s, type: %s, price: %s}", model, memory, type, price);
    }
}
