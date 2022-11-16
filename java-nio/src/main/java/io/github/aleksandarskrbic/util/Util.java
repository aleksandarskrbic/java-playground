package io.github.aleksandarskrbic.util;

public class Util {
    public static int transform(final int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
