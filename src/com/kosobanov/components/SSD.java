package com.kosobanov.components;

import com.kosobanov.Type;

public class SSD {
    public String model;
    public int memory;
    public Type type;
    public int price;
    public int maxWrite;
    public int maxRead;
    public int resource;
    public int rank;

    public SSD(String model, int memory, int maxWrite, int maxRead, int resource, int price) {
        this.model = model;
        this.memory = memory;
        this.price = price;
        this.maxRead = maxRead;
        this.maxWrite = maxWrite;
        this.resource = resource;
        this.type = getType();
        this.rank = getRank();
    }

    public int getRank(){
        return Type.getRank(type) + (maxRead + maxWrite + resource) /10;
    }

    public Type getType(){
        if (memory > 960)
            return Type.P;
        if (memory >= 480)
            return Type.G;
        return Type.W;
    }

    public String toString() {
        return String.format("{Type: SSD, model: %s , memory: %s, type: %s, price: %s}", model, memory, type, price);
    }
}
