package io.github.aleksandarskrbic.util;

import java.nio.ByteBuffer;

public class Util {
    public static int transform(final int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

    public static void transform(final ByteBuffer buf) {
        // buf.limit(buf.position());
        // buf.position(0);

        buf.flip();

        for (int i = 0; i < buf.limit(); i++) {
            buf.put(i, (byte) transform(buf.get(i)));
        }
    }
}
