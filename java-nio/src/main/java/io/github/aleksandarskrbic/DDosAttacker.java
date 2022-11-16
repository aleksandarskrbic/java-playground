package io.github.aleksandarskrbic;

import java.io.IOException;
import java.net.Socket;

public class DDosAttacker {

    public static void main(final String[] args) throws InterruptedException {
        final Socket[] sockets = new Socket[100000];

        for (int i = 0; i < sockets.length; i++) {
            try {
                sockets[i] = new Socket("localhost", 8080);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(100_000);
    }
}
