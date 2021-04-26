package com.kosobanov.components;

import com.kosobanov.Socket;
import com.kosobanov.Type;

public class Processor {
    public String model;
    public Socket socket;
    public int cores;
    public int price;
    public int tdp;
    public int techPro;
    public int freqMax;
    public int freq;
    public Type type;
    public int rank;

    public Processor(String model, Socket socket, int cores, int tdp, int techPro, int freq, int freqMax, int price) {
        this.model = model;
        this.socket = socket;
        this.cores = cores;
        this.price = price;
        this.tdp = tdp;
        this.techPro = techPro;
        this.freq = freq;
        this.freqMax = freqMax;
        this.type = getType();
        this.rank = getRank();
    }

    public int getRank(){
        try{
            return (int) Math.round(cores / 2.0) + Type.getRank(type) + (20 - techPro) + (freqMax + freq)/100;
        }
        catch (NullPointerException e) {
            System.out.println("Для процессора не задано значение");
        }
        return 0;
    }

    public Type getType(){
        if (cores > 8) return Type.P;
        if (cores > 4) return Type.G;
        return Type.W;
    }

    public String toString() {
        return String.format("{Type: Processor, model: %s , socket: %s, TDP: %s, cores: %s,type: %s, price: %s}", model, socket, tdp, cores, type, price);
    }
}
