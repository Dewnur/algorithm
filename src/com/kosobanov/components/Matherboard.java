package com.kosobanov.components;

import com.kosobanov.Chipset;
import com.kosobanov.FormFactor;
import com.kosobanov.Socket;
import com.kosobanov.Type;

import javax.swing.*;
import java.awt.*;

public class Matherboard {
    public String model;
    public Socket socket;
    public Chipset chipset;
    public int PCI;
    public int powPhase;
    public int M2;
    public FormFactor ATX;
    public int price;
    public Type type;
    public int rank;

    public Matherboard(String model, Socket socket, Chipset chipset, int powPhase, int m2, FormFactor ATX, int PCI, int price) {
        this.model = model;
        this.socket = socket;
        this.chipset = chipset;
        this.PCI = PCI;
        this.powPhase = powPhase;
        this.M2 = m2;
        this.ATX = ATX;
        this.price = price;
        this.type = getType();
        this.rank = getRank();
    }

    public int getRank(){
        return powPhase + M2 + PCI + Type.getRank(type);
    }

    public String toString() {
        return String.format("{Type: Matherboard, model: %s , socket: %s, chipset: %s, type: %s, price: %s}", model, socket, chipset, type, price);
    }

    public Type getType() {
        return Type.getTypeChipset(chipset.toString());
    }

    public int compareTo(Matherboard math) {
        return this.model.compareTo(math.model);
    }
}
