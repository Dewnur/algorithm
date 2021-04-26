package com.kosobanov.components;

import com.kosobanov.Type;

import java.awt.*;

abstract class Component {
    public String model;
    public int price;
    public Type type;
    public int rank;

    public Component() {
        this.model = null;
        this.price = 0;
        this.type = null;
        this.rank = 0;
    }

    public Component(String model, int price) {
        this.model = model;
        this.price = price;
        this.type = null;
        this.rank = 0;
    }

    public Component(String model, int price, Type type) {
        this.model = model;
        this.price = price;
        this.type = type;
        this.rank = 0;
    }



    //    public abstract boolean checkComponent();
    public abstract int getRank();
}
