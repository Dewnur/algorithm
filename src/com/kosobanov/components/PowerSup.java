package com.kosobanov.components;

import com.kosobanov.Type;

public class PowerSup {
    public String model;
    public int power;
    public Type type;
    public int price;
    public int rank;

    public PowerSup(String model, int power, int price) {
        this.model = model;
        this.power = power;
        this.price = price;
        this.rank = getRank();
    }

    public int getRank(){
        try{
            return (int) Math.round(((power) / 10.0) / 2.0);
        }
        catch (NullPointerException e) {
            System.out.println("Для бп не задано поле power");
        }
        return 0;
    }

    public String toString() {
        return String.format("{Type: PowerSup, model: %s , power: %s, price: %s}", model, power, price);
    }
}
