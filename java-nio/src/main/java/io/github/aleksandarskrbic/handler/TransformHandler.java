package io.github.aleksandarskrbic.handler;

import io.github.aleksandarskrbic.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TransformHandler implements Handler<Socket> {
    @Override
    public void handle(final Socket socket) throws IOException {
        try (
            socket;
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(Util.transform(data));
            }
        }
    }
}
