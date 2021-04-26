package com.kosobanov;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public enum Socket {
    AM4,
    LGA1151,
    LGA1200;

    public static Socket formString(String text) {
        for (Socket b : Socket.values()) {
            if (Arrays.equals(b.toString().getBytes(), text.getBytes(StandardCharsets.UTF_8))) {
                return b;
            }
        }
        return null;
    }


}
