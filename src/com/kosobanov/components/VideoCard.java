package com.kosobanov.components;

import com.kosobanov.Type;

public class VideoCard {
    public String model;
    public int tdp;
    public int memory;
    public Type type;
    public int price;
    public int memBusBit;
    public int maxMemBandwidth;
    public int rank;


    public VideoCard(String model, int tdp, int memory, int memBusBit, int maxMemBandwidth, int price) {
        this.model = model;
        this.tdp = tdp;
        this.memory = memory;
        this.memBusBit = memBusBit;
        this.maxMemBandwidth = maxMemBandwidth;
        this.price = price;
        this.type = getType();
        this.rank = getRank();
    }

    public int getRank(){
        return Type.getRank(type) + memBusBit + maxMemBandwidth;
    }

    public Type getType() {
        if (memory > 8)
            return Type.P;
        if (memory > 4)
            return Type.G;
        return Type.W;
    }

    public String toString() {
        return String.format("{Type: VideoCard, model: %s , memory: %s, TDP: %s, type: %s, price: %s}", model, memory, tdp, type, price);
    }
}
