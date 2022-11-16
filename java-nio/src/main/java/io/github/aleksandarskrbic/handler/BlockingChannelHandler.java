package io.github.aleksandarskrbic.handler;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class BlockingChannelHandler extends DecoratedHandler<SocketChannel> {
    public BlockingChannelHandler(final Handler<SocketChannel> inner) {
        super(inner);
    }

    @Override
    public void handle(final SocketChannel sc) throws IOException {
        while (sc.isConnected()) {
            super.handle(sc);
        }
    }
}
