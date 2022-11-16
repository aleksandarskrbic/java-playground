package io.github.aleksandarskrbic.handler;

import io.github.aleksandarskrbic.util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TransformChannelHandler implements Handler<SocketChannel> {
    @Override
    public void handle(final SocketChannel sc) throws IOException {
        var buf = ByteBuffer.allocateDirect(80);
        int read = sc.read(buf);

        if (read == -1) {
            sc.close();
            return;
        }

        if (read > 1) {
            Util.transform(buf);

            while (buf.hasRemaining()) {
                sc.write(buf);
            }

            buf.compact();
        }
    }
}
