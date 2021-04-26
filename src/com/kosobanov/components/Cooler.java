package com.kosobanov.components;

import com.kosobanov.Type;

import java.awt.*;

public class Cooler extends Component {
//    public String model;
    public int powDis;
//    public int price;
//    public int rank;

    public Cooler(String model, int powDis, int price) {
//        this.model = model;

        super(model, price);
        this.powDis = powDis;
        this.rank = getRank();
//        this.price = price;
//        this.rank = getRank();
    }

    @Override
    public int getRank(){
        return (int) Math.round((powDis) / 10.0 );
    }

    public String toString() {
        return String.format("{Type: Cooler, model: %s , power_dissipation: %s, price: %s}", model, powDis, price);
    }
}

