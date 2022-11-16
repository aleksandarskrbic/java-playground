package io.github.aleksandarskrbic.blockingserver;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;

import io.github.aleksandarskrbic.handler.LoggingHandler;
import io.github.aleksandarskrbic.handler.ThreadedHandler;
import io.github.aleksandarskrbic.handler.TransformHandler;

public class MultiThreadedBlockingServer {
    public static void main(final String[] args) throws IOException {
        var serverSocket = new ServerSocket(8080);
        var socketHandler =
            new ThreadedHandler<>(
                new LoggingHandler<>(
                    new TransformHandler()
                )
            );

        while (true) {
            final Socket socket = serverSocket.accept();
            socketHandler.handle(socket);
        }
    }
}
