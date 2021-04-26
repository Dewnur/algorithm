package com.kosobanov;

public enum Type {
    P,
    G,
    W;

    public static int getRank(Type t) {
        switch (t) {
            case P:
                return 30;
            case G:
                return 20;
            case W:
                return 10;
        }
        return 0;
    }
    public static Type getTypeChipset(String text) {
        if (text.contains("H") && text.contains("1") ||
                text.contains("A") || text.contains("G")) return W;
        if (text.contains("X") || text.contains("Z")) return P;
        if (text.contains("H") && text.contains("7") ||
                text.contains("B")) return G;
        return null;
    }
}
