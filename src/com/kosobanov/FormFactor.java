package com.kosobanov;

public enum FormFactor {
    Standard,
    Micro,
    Mini;

    public static FormFactor formString(String text) {
        if (text.contains("Standard")) return Standard;
        if (text.toString().contains("Micro")) return Micro;
        if (text.contains("Mini")) return Mini;
        return null;
    }
}
