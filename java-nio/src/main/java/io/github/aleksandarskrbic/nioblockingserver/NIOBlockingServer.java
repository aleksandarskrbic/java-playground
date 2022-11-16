package io.github.aleksandarskrbic.nioblockingserver;

import io.github.aleksandarskrbic.handler.BlockingChannelHandler;
import io.github.aleksandarskrbic.handler.LoggingHandler;
import io.github.aleksandarskrbic.handler.ExecutorServiceHandler;
import io.github.aleksandarskrbic.handler.TransformChannelHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.nio.channels.ServerSocketChannel;

public class NIOBlockingServer {

    public static void main(final String[] args) throws IOException {
        var ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));

        var channelHandler =
            new ExecutorServiceHandler<>(
                new LoggingHandler<>(
                    new BlockingChannelHandler(
                        new TransformChannelHandler()
                    )
                ),
                Executors.newFixedThreadPool(10)
            );


        while (true) {
            var sc =  ssc.accept();
            channelHandler.handle(sc);
        }
    }
}
