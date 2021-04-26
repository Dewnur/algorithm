package com.kosobanov;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public enum Chipset {
    B550,
    Z590,
    B460,
    B450,
    H310,
    H370,
    B365,
    Z490,
    A320,
    A520,
    Z390;

    public static Chipset formString(String text) {
        for (Chipset b : Chipset.values()) {
            if (Arrays.equals(b.toString().getBytes(), text.getBytes(StandardCharsets.UTF_8))) {
                return b;
            }
        }
        return null;
    }
}
